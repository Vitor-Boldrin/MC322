package biblioteca.models.Recursos_Biblioteca;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.LinkedList;
import biblioteca.models.Membro.Membro;

public class Evento {
	private Tipo_evento tipo_evento;
	private LinkedList<Membro> participantes = LinkedList<>();
	
	public Evento(Tipo_evento tipo_evento) {
		this.tipo_evento = tipo_evento;
	}
	
	//geters e seters
	public Tipo_evento getTipo_evento() {
	      return this.tipo_evento;
	}
	
	public void setTipo_evento(Tipo_evento tipo_evento) {
	    this.tipo_evento  = tipo_evento;
	}
	
	// Abstract class com métodos e atributos comuns dos 3 tipos de evento
	public abstract class Evento_biblioteca {
			private Date data_inicio;
			private Date data_fim;
			private String local;
			
			public Evento_biblioteca(Date data_inicio, Date data_fim, String local) {
				this.data_inicio = data_inicio;
				this.data_fim = data_fim;
				this.local = local;
			}
			
			public long duracao_evento_minutos() {
				
				long duração  = this.data_fim.getTime() - this.data_inicio.getTime();
				long dif_minutos = TimeUnit.MILLISECONDS.toMinutes(duração);
				
				return dif_minutos;
				
			}
			
			public Tipo_evento getTipo_evento() {
				return tipo_evento;
			}
			
			public Date getData_inicio() {
			      return this.data_inicio;
			}
			
			public void setData_inicio(Date data_inicio) {
			    this.data_inicio = data_inicio;
			}
			
			public Date getData_fim() {
			      return this.data_fim;
			}
			
			public void setData_fim(Date data_fim) {
			    this.data_fim = data_fim;
			}
			
			public String getLocal() {
			      return this.local;
			}
			
			public void setLocal(String local) {
			    this.local = local;
			}
			
		}
	
	// PALESTRA 
	public class Palestra extends Evento_biblioteca {
		private String topico;
		private String palestrante;
		
		public Palestra(
			Date data_inicio,
			Date data_fim,
			String local,
			String topico,
			String palestrante
			) {
			super(
					data_inicio,
					data_fim,
					local
					);
			this.topico = topico;
			this.palestrante = palestrante;
		}
		
		//seters e geters
		public String getTopico() {
		      return this.topico;
		}
		
		public void setTopico(String topico) {
		    this.topico = topico;
		}
		
		public String getPalestrante() {
		      return this.palestrante;
		}
		
		public void setPalestrante(String palestrante) {
		    this.palestrante = palestrante;
		}
		
	}
	
	//WORKSHOP
	public class Workshop extends Evento_biblioteca {
		private String topico;
		private String instrutor;
		private String materiais;
		
		public Workshop(
			Date data_inicio,
			Date data_fim,
			String local,
			String topico,
			String instrutor,
			String materiais
			) {
			super(
					data_inicio,
					data_fim,
					local
					);
			this.topico = topico;
			this.instrutor = instrutor;
			this.materiais = materiais;
		}
		
		//seters e geters
		public String getTopico() {
		      return this.topico;
		}
		
		public void setTopico(String topico) {
		    this.topico = topico;
		}
		
		public String getInstrutor() {
		      return this.instrutor;
		}
		
		public void setInstrutor(String instrutor) {
		    this.instrutor = instrutor;
		}
		
		public String getMateriais() {
		      return this.materiais;
		}
		
		public void setMateriais(String materiais) {
		    this.materiais = materiais;
		}
		
	}
	
	//EXPOSIÇÃO
	public class Exposição extends Evento_biblioteca {
		private String tema;
		private String expositores;
		
		public Exposição(
			Date data_inicio,
			Date data_fim,
			String local,
			String tema,
			String expositores
			) {
			super(
					data_inicio,
					data_fim,
					local
					);
			this.tema = tema;
			this.expositores = expositores;
		}
		
		//seters e geters
		public String getTema() {
		      return this.tema;
		}
		
		public void setTema(String tema) {
		    this.tema = tema;
		}
		
		public String getExpositores() {
		      return this.expositores;
		}
		
		public void setExpositores(String expositores) {
		    this.expositores = expositores;
		}
		
	}
	
}
