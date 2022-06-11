package br.com.rotaract.secretaria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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

@Service
public class AssociadoService {
	
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
		
		Cargo cargo = cargoRepository.findByNome(associadoDto.getCargo());
		
		Associado associado = new Associado();
		associado.setRI(associadoDto.getRI());
		associado.setStatus(StatusAssociado.ATIVO);
		associado.setDataAdmissao(associadoDto.getAdmissao());
		associado.setPadrinho(associadoDto.getPadrinho());
		associado.setEmail(associadoDto.getEmail());
		associado.setSenha(new BCryptPasswordEncoder().encode(associadoDto.getSenha()));
		associado.setPessoa(pessoa);
		associado.setCargo(cargo);
		
		associadoRepository.save(associado);
		
		return associado;
	}

	public List<Associado> findAssociado() {
		
		List<Associado> associados = associadoRepository.findAll();		
		
		return associados;
	}

	public Associado findAssociado(Long ri) {
		
		Optional<Associado> associado = associadoRepository.findById(ri);

		return associado.get();
	}

	public Associado updateAssociado(Long ri, AssociadoEditDto associadoEditDto) {

		Optional<Associado> optAssociado = associadoRepository.findById(ri);
		Associado associado = optAssociado.get();
		
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
		
		if(!associado.getCargo().getNome().equals(associadoEditDto.getCargo())) {
			Cargo cargo = cargoRepository.findByNome(associadoEditDto.getCargo());
			associado.setCargo(cargo);
		}
		
		associado.setStatus(associadoEditDto.getStatus());
		associado.setDataAdmissao(associadoEditDto.getAdmissao());
		associado.setPadrinho(associadoEditDto.getPadrinho());
		associado.setEmail(associadoEditDto.getEmail());
		
		associadoRepository.save(associado);
		
		return associado;
	}

	public List<PessoaCargo> getByCargo() {
		List<Pessoa> pessoa = pessoaRepository.findByCargo();
		List<PessoaCargo> listPessoasCargo = new ArrayList<>();
		pessoa.forEach(n -> {
			PessoaCargo pessoaCargo = new PessoaCargo();
			pessoaCargo.setNome(n.getNome());
			pessoaCargo.setCargo(n.getAssociado().getCargo().getNome());
			listPessoasCargo.add(pessoaCargo);
		});
		return listPessoasCargo;
	}

	public boolean isValidAuthority(Long ri, User usuarioLogado) {
		Associado associado = associadoRepository.findById(ri).get();
		return associado.getEmail().equals(usuarioLogado.getUsername());
	}
	
	public void deleteAssociado(Long ri) {

		Optional<Associado> optAssociado = associadoRepository.findById(ri);
		if(optAssociado.isPresent()) {
			Associado associado = optAssociado.get();
			associado.setStatus(StatusAssociado.DESLIGADO);
			associadoRepository.save(associado);
		}
	}
}
