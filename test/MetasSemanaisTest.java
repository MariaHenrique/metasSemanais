import static org.junit.Assert.*;
import models.Metas;
import models.MetasDaSemana;
import org.junit.*;

public class MetasSemanaisTest {
	
	private static MetasDaSemana metasDaSemana;
	private static Metas meta1;
	
	@Before
	public void setUp() {
		metasDaSemana = new MetasDaSemana();	
		meta1 =  new Metas("SI1 -LAB2 (Primeira parte)","1", "Completar a primeira aplicação");
	}

	@Test
	public void deveIniciarComSeisSemanasVazias() {		
		assertTrue(MetasDaSemana.getSemanas().size() == 6);		
		
		for(int i = 0; i < 6; i++) {
			assertTrue(MetasDaSemana.getSemanas().get(i).isEmpty());			
		}
	}
	
	@Test
	public void deveAdicionarMetaNasSemanas() {
		

		metasDaSemana.novaMeta(new Metas("SI1 -LAB2 (Primeira parte)","1", "Completar a primeira aplicação"), "1");
		metasDaSemana.novaMeta(new Metas("SI 1 (Miniteste)", "2", "Estudar padrões de projeto"), "2");
		metasDaSemana.novaMeta(new Metas("SI 1 - LAB3", "1", "Começar a fazer o lab3"), "3");
		metasDaSemana.novaMeta(new Metas("Inglês - Prova" ,"1","Estudar todo conteúdo do semestre para a prova"), "4");
		metasDaSemana.novaMeta(new Metas("Lista de Métodos estatísticos", "3", "Responder lista de exercícios do segundo estágio"), "5");
		metasDaSemana.novaMeta(new Metas("Métodos estatísticos - Prova", "1", "Estudar todo o conteúdo do segundo estágio"), "6");

		for(int i = 0; i < 6; i++) {
			assertFalse(MetasDaSemana.getSemanas().get(i).isEmpty());	
			assertTrue(MetasDaSemana.getSemanas().get(0).quantMetas() == 1);	
		}		
		
	}
	
	@Test
	public void devePermitirMarcarMeta() {
		
		assertFalse(meta1.ehMetaAlcancada());
		meta1.marcarMeta();
		assertTrue(meta1.ehMetaAlcancada());
		meta1.marcarMeta();
		assertFalse(meta1.ehMetaAlcancada());
	}
	
	@Test
	public void devePermitirExcluirMeta() {
		
		metasDaSemana.novaMeta(new Metas("SI1 -LAB2 (Primeira parte)","1", "Completar a primeira aplicação"), "1");
		metasDaSemana.novaMeta(new Metas("SI 1 (Miniteste)", "2", "Estudar padrões de projeto"), "2");
		metasDaSemana.novaMeta(new Metas("SI 1 - LAB3", "1", "Começar a fazer o lab3"), "3");
		metasDaSemana.novaMeta(new Metas("Inglês - Prova" ,"1","Estudar todo conteúdo do semestre para a prova"), "4");
		metasDaSemana.novaMeta(new Metas("Lista de Métodos estatísticos", "3", "Responder lista de exercícios do segundo estágio"), "5");
		metasDaSemana.novaMeta(new Metas("Métodos estatísticos - Prova", "1", "Estudar todo o conteúdo do segundo estágio"), "6");

	
		for(int i = 0; i < 6; i++) {
			MetasDaSemana.getSemanas().get(i).getMetas().remove(0);
			assertTrue(MetasDaSemana.getSemanas().get(i).isEmpty());
		}
	}
	
	@Test
	public void deveMostrarQuantidadeDeMetas(){
		
		assertTrue(MetasDaSemana.getSemanas().get(0).isEmpty());
		metasDaSemana.novaMeta(meta1, "1");
		assertTrue(MetasDaSemana.getSemanas().get(0).quantMetas() == 1);
		assertTrue(MetasDaSemana.getSemanas().get(0).quantMetasAlcancadas() == 0);
		assertTrue(MetasDaSemana.getSemanas().get(0).quantMetasDesejadas() == 1);
		meta1.marcarMeta();
		assertTrue(meta1.ehMetaAlcancada());
		assertTrue(MetasDaSemana.getSemanas().get(0).quantMetas() == 1);
		assertTrue(MetasDaSemana.getSemanas().get(0).quantMetasAlcancadas() == 1);
		assertTrue(MetasDaSemana.getSemanas().get(0).quantMetasDesejadas() == 0);
		
	}
	
}