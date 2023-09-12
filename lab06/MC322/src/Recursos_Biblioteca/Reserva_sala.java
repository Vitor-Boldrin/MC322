package Recursos_Biblioteca;
import java.util.Date;

public class Reserva_sala {

	private Date data_reserva;
	private Date hora_inicio;
	private Date hora_fim;
	private Status_reserva_sala status_reserva_sala;
	
	public Reserva_sala(
			Date data_reserva,
			Date hora_inicio,
			Date hora_fim
			) {
		this.data_reserva = data_reserva;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
	}
	
	//geters e seters
	public Date getData_reserva() {
	      return this.data_reserva;
	}
	
	public void setData_reserva(Date data_reserva) {
	    this.data_reserva = data_reserva;
	}
	
	public Date getHora_inicio() {
	      return this.hora_inicio;
	}
	
	public void setHora_inicio(Date hora_inicio) {
	    this.hora_inicio = hora_inicio;
	}
	
	public Date getHora_fim() {
	      return this.hora_fim;
	}
	
	public void setHora_fim(Date hora_fim) {
	    this.hora_fim = hora_fim;
	}
	
	public Status_reserva_sala getStatus_reserva_sala() {
	      return this.status_reserva_sala;
	}
	
	public void setStatus_reserva_sala(Status_reserva_sala status_reserva_sala) {
	    this.status_reserva_sala = status_reserva_sala;
	}
	
	// Inner classes
	public class Sala_individual {
		private boolean tem_computador;
		private int numero_sala;
		
		public Sala_individual(boolean tem_computador, int numero_sala) {
			this.tem_computador = tem_computador;
			this.numero_sala = numero_sala;
		}
		
		//geters da outer class
		public Date getData_reserva() {
			return data_reserva;
		}
		
		public Date getHora_inicio() {
			return hora_inicio;
		}
		
		public Date getHora_fim() {
			return hora_fim;
		}
		
		public Status_reserva_sala getStatus_reserva_sala() {
			return status_reserva_sala;
		}
		
		//geters e seters
		public boolean getTem_computador() {
		      return this.tem_computador;
		}
		
		public void setTem_computador(boolean tem_computador) {
		    this.tem_computador = tem_computador;
		}
		
		public int getnumero_sala() {
		      return this.numero_sala;
		}
		
		public void setNumero_sala(int numero_sala) {
		    this.numero_sala = numero_sala;
		}
		
	}
	
	public class Sala_grupo {
		private boolean tem_recurso;
		private int capacidade_maxima;
		
		public Sala_grupo(boolean tem_recurso, int capacidade_maxima) {
			this.tem_recurso = tem_recurso;
			this.capacidade_maxima = capacidade_maxima;
		}
		
		//geters da outer class
		public Date getData_reserva() {
			return data_reserva;
		}
		
		public Date getHora_inicio() {
			return hora_inicio;
		}
		
		public Date getHora_fim() {
			return hora_fim;
		}
		
		public Status_reserva_sala getStatus_reserva_sala() {
			return status_reserva_sala;
		}
		
				
		//geters e seters
		public boolean getTem_recurso() {
		      return this.tem_recurso;
		}
		
		public void setTem_recurso(boolean tem_recurso) {
		    this.tem_recurso = tem_recurso;
		}
		
		public int getCapacidade_maxima() {
		      return this.capacidade_maxima;
		}
		
		public void setCapacidade_maxima(int capacidade_maxima) {
		    this.capacidade_maxima = capacidade_maxima;
		}
		
	}
	
	public class Sala_silenciosa {
		private boolean tem_cabine_individual;
		private int numero_assentos;
		
		public Sala_silenciosa(boolean tem_cabine_individual, int numero_assentos) {
			this.tem_cabine_individual = tem_cabine_individual;
			this.numero_assentos = numero_assentos;
		}
		
		//geters da outer class
		public Date getData_reserva() {
			return data_reserva;
		}
		
		public Date getHora_inicio() {
			return hora_inicio;
		}
		
		public Date getHora_fim() {
			return hora_fim;
		}
		
		public Status_reserva_sala getStatus_reserva_sala() {
			return status_reserva_sala;
		}
		
		public boolean getTem_cabine_individual() {
		      return this.tem_cabine_individual;
		}
		
		public void setTem_cabine_individual(boolean tem_cabine_individual) {
		    this.tem_cabine_individual = tem_cabine_individual;
		}
		
		public int getNumero_assentos() {
		      return this.numero_assentos;
		}
		
		public void setNumero_assentos(int numero_assentos) {
		    this.numero_assentos = numero_assentos;
		}
		
	}
	
	public class Sala_multimidia {
		private String equipamentos;
		
		public Sala_multimidia(String equipamentos) {
			this.equipamentos = equipamentos;
		}
		
		//geters da outer class
		public Date getData_reserva() {
			return data_reserva;
		}
		
		public Date getHora_inicio() {
			return hora_inicio;
		}
		
		public Date getHora_fim() {
			return hora_fim;
		}
		
		public Status_reserva_sala getStatus_reserva_sala() {
			return status_reserva_sala;
		}
		
		public String getEquipamentos() {
		      return this.equipamentos;
		}
		
		public void setEquipamentos(String equipamentos) {
		    this.equipamentos = equipamentos;
		}
		
	}
	
}
