package br.com.rotaract.secretaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rotaract.secretaria.constant.StatusAssociado;
import br.com.rotaract.secretaria.dto.AssociadoDto;
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

	public Associado createAssociado(AssociadoDto associadoDto) {
		Endereco endereco = new Endereco();
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
		
		Cargo cargo = cargoRepository.findByNome(associadoDto.getCargo().getDescricao());
		
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

	
}
