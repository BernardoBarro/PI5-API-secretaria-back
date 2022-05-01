package br.com.rotaract.secretaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		pessoa.setTelefone(associadoDto.getTelefone());
		pessoa.setNome(associadoDto.getNome());
		pessoa.setNascimento(associadoDto.getNascimento());
		pessoa.setEmail(associadoDto.getEmail());
		pessoa.setCpf(associadoDto.getCpf());
		pessoa.setOcupacao(associadoDto.getOcupacao());
		pessoa.setEndereco(endereco);
		
		pessoaRepository.save(pessoa);
		
		Cargo cargo = new Cargo();
		cargo.setNome(associadoDto.getCargo().getDescricao());
		
		cargoRepository.save(cargo);
		
		Associado associado = new Associado();
		associado.setRI(associadoDto.getRI());
		associado.setRestricaoMedica(associadoDto.getRestricaoMedica());
		associado.setPadrinho(associadoDto.getPadrinho());
		associado.setDataAdmissao(associadoDto.getAdmissao());
		associado.setPessoa(pessoa);
		associado.setCargo(cargo);
		
		associadoRepository.save(associado);
		
		return associado;
	}

	
}
