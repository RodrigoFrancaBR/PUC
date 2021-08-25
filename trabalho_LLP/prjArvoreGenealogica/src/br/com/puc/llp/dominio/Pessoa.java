package br.com.puc.llp.dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

	protected String cpf;
	protected String nome;
	protected int idade;
	protected Pessoa pai;
	protected Pessoa mae;

	protected Pessoa conjuge;
	protected List<Pessoa> exConjuges = new ArrayList<Pessoa>();
	protected List<Pessoa> filhos = new ArrayList<Pessoa>();

	public Pessoa() {
	}
	
	/**
	 * 
	 * @param cpf obrigatório
	 * @param nome obrigatório
	 * @param idade obrigatório
	 * @throws IllegalArgumentException Caso algum dos parametros não seja informado
	 */
	public Pessoa(String cpf, String nome, int idade) throws IllegalArgumentException {

		if (!Cpf.cpfValido(cpf)) {
			throw new IllegalArgumentException("CPF inválido");
		}

		if (!nomeValido(nome)) {
			throw new IllegalArgumentException("Nome inválido");
		}

		if (!idadeValida(idade)) {
			throw new IllegalArgumentException("Idade inválido");
		}

		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
	}
	
	/**
	 * Casa uma pessoa com outra seguindo algumas regras
	 * @param pessoa 
	 * @throws IllegalArgumentException
	 * 
	 */
	public void casar(Pessoa pessoa) throws IllegalArgumentException{

		if (pessoa == null) {
			throw new IllegalArgumentException("Pessoa não informada");
		}

		if (this.equals(pessoa)) {
			throw new IllegalArgumentException("Não pode casar consigo mesmo");
		}

		if (this.getConjuge() != null || pessoa.getConjuge() != null) {
			throw new IllegalArgumentException("Não pode casar com uma pessoa já casada");
		}

		if (this.getIdade() < 18 || pessoa.getIdade() < 18) {
			throw new IllegalArgumentException("Idade mínima para casar é 18 ");
		}

		Parentesco parentesco = verificarParentesco(pessoa);

		if (!parentesco.equals(Parentesco.SEM_PARENTESCO)) {
			throw new IllegalArgumentException("Não pode casar são " + parentesco);
		}

		this.conjuge = pessoa;
		pessoa.conjuge = this;

	}

	/**
	 * 
	 * @param pessoa com quem vc teve o filho(s)
	 * @param filhos um ou mais filhos com a pessoa acima
	 */
	public void terFilhos(Pessoa pessoa, List<Pessoa> filhos) {

		Mulher mae = null;
		Homem pai = null;

		if (pessoa instanceof Mulher) {
			mae = (Mulher) pessoa;
			pai = (Homem) this;
		} else {
			pai = (Homem) pessoa;
			mae = (Mulher) this;
		}

		for (Pessoa filho : filhos) {

			if (!this.filhos.contains(filho)) {
				this.filhos.add(filho);
				filho.pai = pai;
				filho.mae = mae;
			}

			if (!pessoa.filhos.contains(filho)) {
				pessoa.filhos.add(filho);
				filho.pai = pai;
				filho.mae = mae;
			}
		}
	}

	
	/**
	 * 
	 * @param pessoa com quem quer divorciar
	 * @throws IllegalArgumentException
	 */
	public void divorciar(Pessoa pessoa) throws IllegalArgumentException{

		if (pessoa == null) {
			throw new IllegalArgumentException("Pessoa não informada");
		}

		// Eu sou conjuge dessa pessoa? Essa pessoa é meu conjuge ?
		if (!this.equals(pessoa.getConjuge()) || !pessoa.equals(this.getConjuge())) {
			throw new IllegalArgumentException("Pessoa informada não é seu conjuge ou vice versa");
		}

		this.exConjuges.add(pessoa);
		this.conjuge = null;
		pessoa.exConjuges.add(this);
		pessoa.conjuge = null;

	}

	/**
	 * Pessoas com quem casei são: Os ex Conjuges + o conjuge.
	 * @return List<Pessoa>
	 */
	public List<Pessoa> obterHistoricoDeCasamento() {

		List<Pessoa> pessoasComQuemCasei = new ArrayList<>();
		this.getExConjuges().forEach((e) -> pessoasComQuemCasei.add(e));

		if (this.getConjuge() != null) {
			Pessoa conjuge = this.getConjuge();
			pessoasComQuemCasei.add(conjuge);
		}

		return pessoasComQuemCasei;

	}
	
	/**
	 * 
	 * @return Estado civil da pessoa
	 */
	public EstadoCivil obterEstadoCivil() {

		EstadoCivil estadoCivil = null;

		// se não tiver cônjuge e a lista de exConjuges for vazia, é solteiro
		if (this.conjuge == null && this.exConjuges.size() == 0) {
			estadoCivil = EstadoCivil.SOLTEIRO;
		}

		// se não tiver cônjuge e a lista de exConjuges não for vazia, é
		if (this.conjuge == null && this.exConjuges.size() > 0) {
			estadoCivil = EstadoCivil.DIVORCIADO;
		}

		// se tiver conjuge é casado
		if (this.conjuge != null) {
			estadoCivil = EstadoCivil.CASADO;
		}

		return estadoCivil;

	}
	/**
	 * 
	 * @param nome a ser alterado
	 * @throws IllegalArgumentException
	 */
	public void alterarNome(String nome) throws IllegalArgumentException{
		if (!this.nomeValido(nome)) {
			throw new IllegalArgumentException("Nome inválido");
		}
		this.nome = nome;
	}

/**
 * 
 * @param cpf a ser alterado
 * @throws IllegalArgumentException
 */
	public void alterarCpf(String cpf) throws IllegalArgumentException {
		if (!Cpf.cpfValido(cpf)) {
			throw new IllegalArgumentException("CPF inválido");
		}
		this.cpf = cpf;
	}
/**
 * 
 * @param idade a ser alterada
 * @throws IllegalArgumentException
 */
	public void alterarIdade(int idade) throws IllegalArgumentException {

		if (!idadeValida(idade)) {
			throw new IllegalArgumentException("Idade inválido");
		}

		this.idade = idade;
	}
	
	
	/**
	 * Faz um ano de idade para uma pessoa
	 * @throws IllegalArgumentException
	 */
	public void fazerAniverssario() throws IllegalArgumentException {
		int idade = this.idade + 1;

		if (!idadeValida(idade)) {
			throw new IllegalArgumentException("Idade inválido");
		}

		this.idade = idade;

	}
	
	/**
	 * 
	 * @param pessoa
	 * @return Parentesco da pessoa 
	 * @throws IllegalArgumentException
	 */
	public Parentesco obterParentesco(Pessoa pessoa) throws IllegalArgumentException{
		
		Parentesco parentesco = Parentesco.SEM_PARENTESCO;
		
		if (pessoa==null){
			throw new IllegalArgumentException("Pessoa não informada");
		}
		
		if (this.equals(pessoa)){
			return Parentesco.MESMA_PESSOA;
		}

		if (this.getPai() == null && this.getMae() == null) {
			parentesco =  Parentesco.SEM_PARENTESCO;
		}

		if (pessoa.getPai() == null && pessoa.getMae() == null) {
			parentesco =   Parentesco.SEM_PARENTESCO;
		}

		if (eMeuFilhoOuFilha(pessoa)) {
			return pessoa instanceof Homem ? Parentesco.FILHO : Parentesco.FILHA;
		}

		if (eMeuPaiOuMae(pessoa)) {
			return pessoa instanceof Homem ? Parentesco.PAI : Parentesco.MAE;
		}

		if (eMeuMaridoOuEsposa(pessoa)) {
			return pessoa instanceof Homem ? Parentesco.MARIDO : Parentesco.ESPOSA;
		}

		if (eMeuAvoOuMinhaAvo(pessoa)) {
			return pessoa instanceof Homem ? Parentesco.AVÔ : Parentesco.AVÓ;
		}

		if (eMeuNetoOuNeta(pessoa)) {
			return  pessoa instanceof Homem ? Parentesco.NETO : Parentesco.NETA;
		}

		if (eMeuTioOuTia(pessoa)) {
			return  pessoa instanceof Homem ? Parentesco.TIO : Parentesco.TIA;
		}

		if (eMeuSobrinhoOuSobrinha(pessoa)) {
			return  pessoa instanceof Homem ? Parentesco.SOBRINHO : Parentesco.SOBRINHA;
		}
		
		if (somosIrmaos(pessoa)){
			return  pessoa instanceof Homem ? Parentesco.IRMÃO : Parentesco.IRMÃ;
		}
		
		if(somosPrimos(pessoa)){
			return  pessoa instanceof Homem ? Parentesco.PRIMO : Parentesco.PRIMA;
		}
		
		return parentesco;
	}
	
	/**
	 * Verifica o grau de parentesco de uma pessoa
	 * 
	 * @param pessoa
	 * @return Parentesco
	 */
	private Parentesco verificarParentesco(Pessoa pessoa) {

		if (somosIrmaos(pessoa)) {
			return Parentesco.IRMAOS;
		}

		if (somosPrimos(pessoa)) {
			return Parentesco.PRIMOS;
		}

		if (eMeuPaiOuMae(pessoa)) {
			return Parentesco.PAIS;
		}

		if (eMeuTioOuTia(pessoa)) {
			return Parentesco.TIOS;
		}

		if (eMeuAvoOuMinhaAvo(pessoa)) {
			return Parentesco.AVÓS;
		}

		return Parentesco.SEM_PARENTESCO;

	}	

	/**
	 * Valida se um nome é válido baseado na regra: Nome precisa ter no mínimo 3
	 * caracteres
	 * 
	 * @param nome
	 * @return true ou false
	 */
	private boolean nomeValido(String nome) {

		if (nome == null || nome.isEmpty() || nome.length() < 3) {
			return false;
		}

		return true;
	}

	/**
	 * Valida se uma idade é válida baseado na regra: Idade precisa ser maior ou
	 * igual a zero (0) e deve ser menor que 200
	 * 
	 * @param idade
	 * @return true ou false
	 */
	private boolean idadeValida(int idade) {

		if (idade < 0 || idade > 200) {
			return false;
		}

		return true;
	}

	/**
	 * Valida se uma pessoa eh seu filho ou filha	
	 * @param pessoa
	 * @return true ou false
	 */
	private boolean eMeuFilhoOuFilha(Pessoa pessoa) {
		return this.filhos.contains(pessoa);
	}

	
	/**
	 * Valida se uma pessoa eh pai ou mae da outra
	 * Se eu tiver pai e o meu pai for igual a pessoa ou se eu tiver mae e minha 
	 * mae for igual a pessoa 
	 * @param pessoa
	 * @return true ou false
	 */
	private boolean eMeuPaiOuMae(Pessoa pessoa) {
		return this.getPai() != null && 
				this.getPai().equals(pessoa) ||
				this.getMae() != null && 
				this.getMae().equals(pessoa);
	}
		
	/**
	 * valida se uma pessoa eh meu marido ou esposa 
	 * @param pessoa
	 * @return true ou false
	 */
	private boolean eMeuMaridoOuEsposa(Pessoa pessoa) {				
		return this.conjuge != null &&
				this.conjuge.equals(pessoa) && 
				pessoa.conjuge != null && 
				pessoa.conjuge.equals(this);
	}

	/**
	 * valida se uma pessoa eh meu avô ou avó
	 * Se eu tiver pai e o meu pai tiver um pai e o pai do meu pai for igual a 
	 * pessoa ou se eu tiver mae e minha mae tiver mae e a mae da minha mae for 
	 * igual a pessoa 
	 * @param pessoa
	 * @return true ou false
	 */
	private boolean eMeuAvoOuMinhaAvo(Pessoa pessoa) {
		return this.getPai() != null &&
				this.getPai().eMeuPaiOuMae(pessoa) ||
				this.getMae() != null &&
				this.getMae().eMeuPaiOuMae(pessoa);
	}

	/** Valida se uma pessoa eh meu neto ou neta
	 * 
	 * @param pessoa
	 * @return true ou false
	 */
	private boolean eMeuNetoOuNeta(Pessoa pessoa) {
		for (Pessoa filho : this.filhos) {
			if (filho.filhos.contains(pessoa)) {
				return true;
			}
		}
		return false;
	}


	/**Valida se uma pessoa e meu tio ou tia
	 * Se eu tiver pai e o meu pai for irmao da pessoa ou se eu tiver mae e
	 * minha mae for irmao da pessoa
	 * @param pessoa
	 * @return true ou false
	 */
	private boolean eMeuTioOuTia(Pessoa pessoa) {	
		return this.getPai() != null &&
				this.getPai().somosIrmaos(pessoa)||
				this.getMae() != null &&
				this.getMae().somosIrmaos(pessoa);
	}
	
	/**
	 * Valida se uma pessoa e meu sobrinho ou sobrinha  
	 * @param pessoa
	 * @return true ou false
	 */
	private boolean eMeuSobrinhoOuSobrinha(Pessoa pessoa) {
		
		if (pessoa.getPai()==null){
			return false;			
		}
		
		return (this.somosIrmaos(pessoa.getPai()) ||
				this.somosIrmaos(pessoa.getMae()));
	}
		
	/**
	 * Valida se uma pessoa eh meu irmao 
	 * Se eu tiver pai e o meu pai for igual ao pai da pessoa ou se eu tiver mae e 
	 * minha mae for igual a mae da pessoa
	 * @param pessoa
	 * @return true ou false
	 */
	private boolean somosIrmaos(Pessoa pessoa) {
		
		return this.getPai() != null &&
				pessoa.getPai() != null &&
				this.getPai().equals(pessoa.getPai()) ||
				this.getMae() != null && 
				pessoa.getMae() != null &&
				this.getMae().equals(pessoa.getMae());				
		
	
	}

	/**
	 * Valida se uma pessoa eh meu primo 
	 * Se eu tiver pai e o meu pai for irmao do pai da pessoa(pai ou mae) 
	 * ou se eu tiver mae e minha mae for irma da mae da pessoa (pai ou mae)
	 *  
	 * @param pessoa
	 * @return true ou false
	 */
	private boolean somosPrimos(Pessoa pessoa) {
		
		if (this.getPai() != null && pessoa.getPai() != null) {
			
			boolean somosIrmaosPartePai = this.getPai()
										.somosIrmaos(pessoa.getPai());
			
			boolean somosIrmaosParteMae = this.getPai()
										.somosIrmaos(pessoa.getMae());
			
			if (somosIrmaosPartePai || somosIrmaosParteMae){
				return true;
			}
			
		}
		
		if (this.getMae() != null && pessoa.getMae() != null) {
			
			boolean  somosIrmaosParteMae = this.getMae()
										 .somosIrmaos(pessoa.getMae());
			
			boolean somosIrmaosPartePai = this.getMae()
										.somosIrmaos(pessoa.getPai());
			
			if (somosIrmaosParteMae || somosIrmaosPartePai){
				return true;
			}
			
		}
		
		return false;				
	}
	
	/**
	 * Gets
	 * @return
	 */
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public int getIdade() {
		return idade;
	}

	public Pessoa getConjuge() {
		return conjuge;
	}

	public List<Pessoa> getExConjuges() {
		return exConjuges;
	}

	public List<Pessoa> getFilhos() {
		return filhos;
	}

	public Pessoa getPai() {
		return pai;
	}

	public Pessoa getMae() {
		return mae;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	


}
