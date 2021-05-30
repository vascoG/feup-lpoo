Relatório Intermédio - Projeto LPOO 2021 - Grupo 41
===============

## Wild West StickMan

**Breve descrição do Jogo:**



Este projeto é parcialmente baseado no clássico offline **T-REX game**, jogo integrado no navegador Google Chrome.

O objectivo do jogo é ir coletando tokens, que contribuem para o score final do utilizador, enquanto que a personagem principal do jogo, neste caso uma espécie de stickman, corre pelo deserto até ficar sem vidas. Ao longo do jogo existem vários obstáculos diferentes com comportamentos diferentes em contacto com a personagem.


**Funcionamento do Jogo**

Em termos de movimento, a personagem principal está estática horizontalmente e apenas apresenta movimentos verticais controlados pelo utilizador, seja o salto (tecla 'w'), agachamento (tecla 's') ou o salto duplo(tecla 'e').

Os obstáculos que o jogador enfrenta estão dividos em dois tipos: ***DangerousObstacles*** (retiram vida à personagem) e ***Thiefs*** (roubam pontos do score do jogador). Nos obstáculos perigosos existe o *barrel* (a personagem morre instantaneamente) e o *cactus* (retiram 1 unidade de vida). Nos ladrões temos o *robber* (reduz o score do jogador para 0) e o *pickpocket* (retira 50% do score do jogador).

Em relação à dificuldade do jogo, ao longo do jogo a velocidade da passagem dos obstáculos pelo personagem vai aumentando, o que dificulta a reação do jogador perante estes.


**Funcionalidades**


##### -> Salto Duplo

##### -> Agachamento

##### -> Salto

##### -> Apanhar Moedas

##### -> Deteção de Colisões

##### -> Desenhar

##### -> Alteração de Score(Incremento e Decremento)

##### -> Contador de Vida

##### -> HighScore

##### -> Verificar se o jogador perdeu o jogo a cada movimento


**Princípios (SOLID)**


##### -> S (The Single Responsibility Principle)

"The single responsibility principle" pode ser exemplificado no nosso jogo em classes como Elemento(guarda apenas a sua posição)

##### -> O (The Open-Closed Principle)

"The open-closed principle" pode ser exemplificada no nosso jogo na medida em que mais um obstáculo envolvia apenas criar mais uma classe que estendia a classe Obstáculo 

##### -> L (The Liskov Substitution Principle)

"The Liskov substitution principle" - Position na Classe Elemento

##### -> I (The Interface  Segregation Principle)

"The interface segregation principle" - Não exemplificado no Diagrama

##### -> D (The Dependency Inversion Principle)

"The dependency inversion principle" - Não exemplificado no Diagrama



**Modelo de design**

	O desenho do nosso projeto está focado numa abordagem de generalização de classes, como base temos a classe Elemento que diverge para os 3 elementos principais que queremos apresentar ao utilizador (Cowboy, FixedObject, MobileObject).
	
	Em termos de desenhar estes objetos e a arena de jogo no ecrã do utilizador, a preocupação foi que classes como a classe Arena tivessem demasiada responsabilidade no que toca à execução do programa. Como solução, implementou-se uma Classe ArenaDrawer, cuja única responsabilidade é desenhar no ecrã a arena de jogo.
	
	Toda a parte gráfica do jogo passa pela interface GUI que implementa a classe LanternaGUI, esta por sua vez utiliza as funções da interface gráfica Lanterna  que gerem o terminal, como close(), refresh() e clear().


**A funcionar**

	Na versão atual do código está funcionar o display parcial da arena, display da personagem principal e reconhecimento de input do utilizador.
	
![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/JogoV1.png?raw=true)


**Padrões de Design**

	##### Problema no Contexto
		O jogo utiliza o Lanterna como ferramenta para desenhar os vários elementos. 
		No entanto, não queríamos que a classe Element dependesse diretamente do Lanterna, visto que seria uma violação ao ***The Dependency Inversion Principle***. 
		Outro princípio que queríamos seguir era o ***The Interface Segregation Principle*** para que o nosso jogo tivesse uma implementação concreta da interface GUI.

	##### O Padrão
		Para este problema, aplicamos o padrão de design ***Adapter***. 
		Este padrão permite que as classes que necessitem do Lanterna usem métodos mais simples em vez de trabalharem diretamente com os métodos do Lanterna.

	##### Implementação
		A imagem seguinte demonstra como é que o padrão de design foi implementado
		![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/adapter.png?raw=true)
		
		As classes referidas são as seguintes:
		[Element](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/Element.java)
		[LanternaGUI](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/LanternaGUI.java)
		[GUI](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/GUI.java)
		[Lanterna](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/f45ab66d791b5e5cc28f3ade897d0dd39f08380b/project/src/main/java/LanternaGUI.java#L1-L10)
	
	##### Consequências
		O uso deste padrão permitiu-nos trabalhar com a implementação da interface feita por nós(LanternaGUI) em vez de trabalharmos diretamente com o Lanterna, o que é uma vantagem, visto que tem métodos mais simples.
		Outro benefício deste padrão é o facto que, se por algum motivo, deixarmos de trabalhar com o Lanterna e trabalhássemos com outra libraria, apenas teríamos de criar uma classe que implementasse a interface GUI.


**Diagrama UML**

![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/DiagramaUML.png?raw=true)






















