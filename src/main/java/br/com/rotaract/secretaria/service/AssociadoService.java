package br.com.rotaract.secretaria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.client.ViaCepClient;
import br.com.rotaract.secretaria.constant.StatusAssociado;
import br.com.rotaract.secretaria.dto.AssociadoDto;
import br.com.rotaract.secretaria.dto.AssociadoEditDto;
import br.com.rotaract.secretaria.dto.PessoaCargo;
import br.com.rotaract.secretaria.dto.ViaCepObject;
import br.com.rotaract.secretaria.model.Associado;
import br.com.rotaract.secretaria.model.Cargo;
import br.com.rotaract.secretaria.model.Endereco;
import br.com.rotaract.secretaria.model.Pessoa;
import br.com.rotaract.secretaria.repository.AssociadoRepository;
import br.com.rotaract.secretaria.repository.CargoRepository;
import br.com.rotaract.secretaria.repository.EnderecoRepository;
import br.com.rotaract.secretaria.repository.PessoaRepository;
import br.com.rotaract.secretaria.utils.BuildError;

@Service
public class AssociadoService {

	private final static String NOT_FOUND_ASSOCIADO = "O associado não existe";
	private final static String NOT_FOUND_CARGO = "O cargo não existe";
	
	@Autowired
	private AssociadoRepository associadoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepClient client;

	public Associado createAssociado(AssociadoDto associadoDto) {

		Optional<Associado> optAssociado = associadoRepository.findById(associadoDto.getRI());
		BuildError.buildAssociadoExiste(optAssociado, "O associado já existe");
		
		Optional<Cargo> optCargo = cargoRepository.findByNome(associadoDto.getCargo());
		BuildError.buildNotFoundException(optCargo, NOT_FOUND_CARGO);

		Endereco endereco = new Endereco();
		ViaCepObject viaCep = client.getEndereco(associadoDto.getCep());
		endereco.setCep(associadoDto.getCep());
		endereco.setRua(viaCep.getLogradouro());
		endereco.setBairro(viaCep.getBairro());
		endereco.setCidade(viaCep.getLocalidade());
		
		enderecoRepository.save(endereco);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(associadoDto.getNome());
		pessoa.setGenero(associadoDto.getGenero());
		pessoa.setOcupacao(associadoDto.getOcupacao());
		pessoa.setNascimento(associadoDto.getNascimento());
		pessoa.setTelefone(associadoDto.getTelefone());
		pessoa.setEndereco(endereco);
		
		pessoaRepository.save(pessoa);
		
		Associado associado = new Associado();
		associado.setRI(associadoDto.getRI());
		associado.setStatus(StatusAssociado.ATIVO);
		associado.setAdmissao(associadoDto.getAdmissao());
		associado.setPadrinho(associadoDto.getPadrinho());
		associado.setEmail(associadoDto.getEmail());
		associado.setSenha(new BCryptPasswordEncoder().encode(associadoDto.getSenha()));
		associado.setPessoa(pessoa);
		associado.setCargo(optCargo.get());
		
		associadoRepository.save(associado);
		
		return associado;
	}

	public List<Associado> findAssociados() {
		
		List<Associado> associados = associadoRepository.findAll();
		associados.remove(0);
		
		return associados;
	}

	public Associado findAssociado(Long ri) {
		
		Optional<Associado> optAssociado = associadoRepository.findById(ri);
		BuildError.buildNotFoundException(optAssociado, NOT_FOUND_ASSOCIADO);

		return optAssociado.get();
	}

	public Associado updateAssociado(Long ri, AssociadoEditDto associadoEditDto) {

		Optional<Associado> optAssociado = associadoRepository.findById(ri);
		BuildError.buildNotFoundException(optAssociado, NOT_FOUND_ASSOCIADO);
		Associado associado = optAssociado.get();
		
		if(!associado.getCargo().getNome().equals(associadoEditDto.getCargo())) {
			Optional<Cargo> optCargo = cargoRepository.findByNome(associadoEditDto.getCargo());
			BuildError.buildNotFoundException(optCargo, NOT_FOUND_CARGO);
			associado.setCargo(optCargo.get());
		}
		
		if(!associado.getPessoa().getEndereco().getCep().equals(associadoEditDto.getCep())) {
			associado.getPessoa().getEndereco().setCep(associadoEditDto.getCep());
			ViaCepObject viaCep = client.getEndereco(associadoEditDto.getCep());
			associado.getPessoa().getEndereco().setRua(viaCep.getLogradouro());
			associado.getPessoa().getEndereco().setBairro(viaCep.getBairro());
			associado.getPessoa().getEndereco().setCidade(viaCep.getLocalidade());
		}
		
		associado.getPessoa().setNome(associadoEditDto.getNome());
		associado.getPessoa().setGenero(associadoEditDto.getGenero());
		associado.getPessoa().setOcupacao(associadoEditDto.getOcupacao());
		associado.getPessoa().setNascimento(associadoEditDto.getNascimento());
		associado.getPessoa().setTelefone(associadoEditDto.getTelefone());
		
		associado.setStatus(associadoEditDto.getStatus());
		associado.setAdmissao(associadoEditDto.getAdmissao());
		associado.setPadrinho(associadoEditDto.getPadrinho());
		associado.setEmail(associadoEditDto.getEmail());
		
		associadoRepository.save(associado);
		
		return associado;
	}

	public List<PessoaCargo> getByCargo() {
		List<Pessoa> pessoa = pessoaRepository.findByCargoIn();
		List<PessoaCargo> listPessoasCargo = new ArrayList<>();
		pessoa.forEach(n -> {
			PessoaCargo pessoaCargo = new PessoaCargo();
			pessoaCargo.setNome(n.getNome());
			pessoaCargo.setCargo(n.getAssociado().getCargo().getNome());
			listPessoasCargo.add(pessoaCargo);
		});
		return listPessoasCargo;
	}

	public boolean isValidAuthority(Long ri, String usuarioLogado) {
		Optional<Associado> optAssociado = associadoRepository.findByEmail(usuarioLogado);
		BuildError.buildNotFoundException(optAssociado, NOT_FOUND_ASSOCIADO);
		Associado associado = optAssociado.get();
		if(associado.getCargo().getAcesso().getNome().equals("ADMIN")) {
			return true;
		}
		return associado.getRI().equals(ri);
	}
	
	public void deleteAssociado(Long ri) {

		Optional<Associado> optAssociado = associadoRepository.findById(ri);
		BuildError.buildNotFoundException(optAssociado, NOT_FOUND_ASSOCIADO);
		Associado associado = optAssociado.get();
		associado.setStatus(StatusAssociado.DESLIGADO);
		associadoRepository.save(associado);
	}
}
