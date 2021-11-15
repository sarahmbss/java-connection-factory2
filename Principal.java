package bancoDados;

import java.util.Scanner;

public class Principal {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
        
		CategoriesDao categoriedao = new CategoriesDao();
		
		System.out.println("###------------Teste Crud Users----------###");
		
		//criando usuário com id 1, para conseguir encontrar usuário em operações futuras
		System.out.println("###------------Criar usuario");
		CategoriesModel categories = new CategoriesModel();
		categories.setData(3, "vestido","vestidos femininos");
		try {
			categoriedao.inserir(categories);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		System.out.print("(Aperte 'Enter' para continuar ....)");
        s.nextLine();
        System.out.println(" ");
        System.out.println(" ");
		
        
        //Lendo todos usuários
		System.out.println("###------------Ler categorias");
		try {
			categoriedao.selectAll();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		System.out.print("(Aperte 'Enter' para continuar ....)");
        s.nextLine();
        System.out.println(" ");
        System.out.println(" ");
		
        
        //Atualizando usuário
		System.out.println("###------------Atualizar usuario por id");
		/*id no banco está auto incrementável, geralmente o valor do id e os dados a serem atualizados 
		* vem na requisição do frontend, mas neste caso vou utilizar um id "manual" =1.
		* */
		try {
		categories = categoriedao.selectById(1);
		categories.setName("CategoriaAtualizadaJava");
		categoriedao.updateById(categories);	
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		System.out.print("(Aperte 'Enter' para continuar ....)");
        s.nextLine();
        System.out.println(" ");
        System.out.println(" ");
		
		
		//apagando usuário por id(id=1), assim em toda execução desse código, não temos o conflito de dois registros com o mesmo id
		System.out.println("###------------Deletar categoria por id");
		try {
			categories = categoriedao.selectById(1);
			categoriedao.deleteById(categories);	
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		System.out.print("(Aperte 'Enter' para continuar ....)");
        s.nextLine();
        System.out.println(" ");
        System.out.println(" ");
        
        
        s.close();
	}
}

