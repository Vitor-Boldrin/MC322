package biblioteca.metadados;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import biblioteca.models.Item.Item;
import biblioteca.models.Membro.Membro;

public class CReflection {
	
	// Construtor
	public CReflection() {
		
	}
	
	// Métodos
	private String ColetaAtributosObjeto(Object objeto) throws IllegalAccessException {
		
		StringBuffer buffer = new StringBuffer();
	    Field[] fields = objeto.getClass().getDeclaredFields();
	    for (Field f : fields) {
	      if (!Modifier.isStatic(f.getModifiers())) {
	        f.setAccessible(true);
	        Object value = f.get(objeto);
	        buffer.append(f.getType().getName());
	        buffer.append(" ");
	        buffer.append(f.getName());
	        buffer.append("=");
	        buffer.append("" + value);
	        buffer.append("\n");
	      }
	    }
	    return buffer.toString();
	}
	
	public void ImprimiAtributos(LinkedList<Membro> membros, LinkedList<Item> itens) throws IllegalArgumentException, IllegalAccessException {
		
		System.out.println("Lista de Membros e seus atributos:\n");
		
		for( Membro membro : membros) {
			for (Field field : membro.getClass().getSuperclass().getDeclaredFields()) {
		        field.setAccessible(true);
		        String name = field.getName();
		        Object value = field.get(membro);
		        System.out.printf("%s: %s%n", name, value);
		    }
		
			for (Field field : membro.getClass().getDeclaredFields()) {
		        field.setAccessible(true);
		        String name = field.getName();
		        Object value = field.get(membro);
		        System.out.printf("%s: %s%n", name, value);
		    }
			System.out.println("\n");
		}
			
		
		
		System.out.println("\n");
		
		System.out.println("Lista de Itens Multimidia e seus atributos:\n");
		
		for( Item item : itens) {
			for (Field field : item.getClass().getSuperclass().getDeclaredFields()) {
		        field.setAccessible(true);
		        String name = field.getName();
		        Object value = field.get(item);
		        System.out.printf("%s: %s%n", name, value);
		    }
		
			for (Field field : item.getClass().getDeclaredFields()) {
		        field.setAccessible(true);
		        String name = field.getName();
		        Object value = field.get(item);
		        System.out.printf("%s: %s%n", name, value);
		    }
			System.out.println("\n");
		
		}
    	}
	
	public void ImprimeMetodos(LinkedList<Membro> membros, LinkedList<Item> itens) {
		System.out.println("Membro e seus métodos:\n");
		
		Membro membro = membros.getFirst();
			try {
				Method method = membro.getClass().getMethod("toString");
				System.out.println(method.invoke(membro));
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			Method[] methods = membro.getClass().getMethods();
		      System.out.println("The public methods of the java.lang.Thread class are:");
		      for (int i = 0; i < methods.length; i++) {
		         System.out.println(methods[i]);
		      }
			
		
		
		System.out.println("\n");
		
		System.out.println("Item Multimidia e seus métodos:\n");
		
		Item item = itens.getFirst();		
			try {
				Method method2 = item.getClass().getMethod("toString");
				System.out.println(method2.invoke(item));
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			Method[] methods2 = item.getClass().getMethods();
		      System.out.println("The public methods of the java.lang.Thread class are:");
		      for (int i = 0; i < methods2.length; i++) {
		         System.out.println(methods2[i]);
		      }
			
		
	}
	
	public void MetadadosLista() {
		
	}
	
	
}
