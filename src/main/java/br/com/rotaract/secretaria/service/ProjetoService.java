package br.com.rotaract.secretaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.constant.StatusAssociado;
import br.com.rotaract.secretaria.dto.ProjetoDto;
import br.com.rotaract.secretaria.model.Associado;
import br.com.rotaract.secretaria.model.Cargo;
import br.com.rotaract.secretaria.model.Instituicao;
import br.com.rotaract.secretaria.model.Pessoa;
import br.com.rotaract.secretaria.model.Projeto;
import br.com.rotaract.secretaria.repository.CargoRepository;
import br.com.rotaract.secretaria.repository.EnderecoRepository;
import br.com.rotaract.secretaria.repository.InstituicaoRepository;
import br.com.rotaract.secretaria.repository.PessoaRepository;

@Service
public class ProjetoService {
	
	private final String ASSOCIADO = "Associado";
	
	@Autowired
	private InstituicaoRepository instituicaoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Projeto criacaoProjeto(ProjetoDto projetoDto) {
		List<Instituicao> instituicao;
		
		Cargo cargo = cargoRepository.findByNome(ASSOCIADO);
		//pesquisa endereço no viacep
		endereco.setCep(associadoDto.getCep());
		
		enderecoRepository.save(endereco);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(associadoDto.getNome());
		pessoa.setGenero(associadoDto.getGenero());
		pessoa.setOcupacao(associadoDto.getOcupacao());
		pessoa.setNascimento(associadoDto.getNascimento());
		pessoa.setEmail(associadoDto.getEmail());
		pessoa.setTelefone(associadoDto.getTelefone());
		pessoa.setSenha(associadoDto.getSenha());
		pessoa.setEndereco(endereco);
		
		pessoaRepository.save(pessoa);
		
		Cargo cargo = cargoRepository.findByNome(ASSOCIADO);
		
		Associado associado = new Associado();
		associado.setRI(associadoDto.getRI());
		associado.setStatus(StatusAssociado.ATIVO);
		associado.setDataAdmissao(associadoDto.getAdmissao());
		associado.setPadrinho(associadoDto.getPadrinho());
		associado.setPessoa(pessoa);
		associado.setCargo(cargo);
		
		associadoRepository.save(associado);
		
		return associado;
	}

//	public List<Associado> findAssociado() {
//		
//		List<Associado> associados = associadoRepository.findAll();		
//		
//		return associados;
//	}
//
//	public Associado findAssociado(Long ri) {
//		
//		Optional<Associado> associado = associadoRepository.findById(ri);
//
//		return associado.get();
//	}
//
//	public Associado updateAssociado(Long ri, AssociadoEditDto associadoEditDto) {
//
//		Optional<Associado> optAssociado = associadoRepository.findById(ri);
//		Associado associado = optAssociado.get();
//		
//		if(!associado.getPessoa().getEndereco().getCep().equals(associadoEditDto.getCep())) {
//			associado.getPessoa().getEndereco().setCep(associadoEditDto.getCep());
//			//pesquisa endereço no viacep
//		}
//		
//		associado.getPessoa().setNome(associadoEditDto.getNome());
//		associado.getPessoa().setGenero(associadoEditDto.getGenero());
//		associado.getPessoa().setOcupacao(associadoEditDto.getOcupacao());
//		associado.getPessoa().setNascimento(associadoEditDto.getNascimento());
//		associado.getPessoa().setEmail(associadoEditDto.getEmail());
//		associado.getPessoa().setTelefone(associadoEditDto.getTelefone());
//		
//		if(!associado.getCargo().getNome().equals(associadoEditDto.getCargo().getDescricao())) {
//			Cargo cargo = cargoRepository.findByNome(associadoEditDto.getCargo().getDescricao());
//			associado.setCargo(cargo);
//		}
//		
//		associado.setStatus(associadoEditDto.getStatus());
//		associado.setDataAdmissao(associadoEditDto.getAdmissao());
//		associado.setPadrinho(associadoEditDto.getPadrinho());
//		
//		associadoRepository.save(associado);
//		
//		return associado;
//	}

	
}
