LPOO_<4><1> - <PROJECT Wild West StickMan>
===============



**Breve descrição do Jogo:**



Este projeto é parcialmente baseado no clássico offline **T-REX game**, jogo integrado no navegador Google Chrome.

O objectivo do jogo é ir coletando tokens, que contribuem para o score final do utilizador, enquanto que a personagem principal do jogo, neste caso uma espécie de stickman, corre pelo deserto até ficar sem vidas. Ao longo do jogo existem vários obstáculos diferentes com comportamentos diferentes em contacto com a personagem.

Este projeto foi desenvolvido por Vasco Gomes (up201906617@fe.up.pt), João Silva (up201906478@fe.up.pt) e Duarte Sardão (up201905497@fe.up.pt) para LPOO 2021.


**Funcionamento do Jogo**

Em termos de movimento, a personagem principal está estática horizontalmente e apenas apresenta movimentos verticais controlados pelo utilizador, seja o salto (tecla 'w'), agachamento (tecla 's') ou o salto duplo(tecla 'e').

Os obstáculos que o jogador enfrenta estão dividos em dois tipos: ***DangerousObstacles*** (retiram vida à personagem) e ***Thiefs*** (roubam pontos do score do jogador). Nos obstáculos perigosos existe o *barrel* (a personagem morre instantaneamente) e o *cactus* (retiram 1 unidade de vida). Nos ladrões temos o *robber* (reduz o score do jogador para 0) e o *pickpocket* (retira 50% do score do jogador).

Em relação à dificuldade do jogo, ao longo do jogo a velocidade da passagem dos obstáculos pelo personagem vai aumentando, o que dificulta a reação do jogador perante estes.


**Funcionalidades**


##### -> Salto Duplo

##### -> Salto

##### -> Apanhar Moedas

##### -> Deteção de Colisões

##### -> Desenhar

##### -> Alteração de Score(Incremento e Decremento)

##### -> Contador de Vida

##### -> Aumentar a dificuldade

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

	Na versão final do código todas as funcionalidades acima descritas foram implementadas com sucesso.
	
	Segue-se screenshots de algumas funcionalidades : 
	
#####   Salto Duplo
	
	O salto duplo ocorre quando o utilizador pressiona  a tecla E e permite que a personagem alcance uma distância mais elevada
em relação ao salto normal o que por consequência ajudar o utilizar a coletar certas moedas e a esquivar-se de certos obstáculos.

![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/SaltoDuplo.png?raw=true)


#####   Score
	
	O score contabiliza o número de moedas que o jogador conseguiu coletar ao longo do jogo, este pode ser incrementado sempre
que é coletada uma moeda e decrementado quando o a personagem colide com um obstáculo cuja função é retirar total ou parcialmente 
pontos do score.


![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/Score.png?raw=true)


##### 	Contador de Vida
	
	O utilizador tem inicialmente 3 vidas (pode sofrer 3 colisões com obstáculos sem perder o jogo). Estas vidas
são representadas graficamente por 3 corações desenhados na tela de jogo.

![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/Vidas.png?raw=true)


**Padrões de Design**

## 1º

##### Problema no Contexto

O jogo utiliza o Lanterna como ferramenta para desenhar os vários elementos. 
No entanto, não queríamos que a classe Element dependesse diretamente do Lanterna, visto que seria uma violação ao ***The Dependency Inversion Principle***. 
Outro princípio que queríamos seguir era o ***The Interface Segregation Principle*** para que o nosso jogo tivesse uma implementação concreta da interface GUI.

##### O Padrão

Para este problema, aplicamos o padrão de design **Adapter**. 
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


## 2º

##### Problema no Contexto

As consequências de cada colisão em que a personagem participa tem que ser diferentes de acordo com o objeto que colide.
A deteção de colisões é uma funcionalidade essencial	e o objetivo seria não condicionar toda informação recorrente a uma
colisão numa só função


##### O Padrão

Para este problema, aplicamos o padrão de design **Strategy**. 
Este padrão permite definir uma família de algoritmos, encapsular cada um e torná-los intercambiáveis. **Strategy** permite que o algoritmo varie dependendo dos clientes que o utilizam.
	
##### Implementação

A imagem seguinte demonstra como é que o padrão de design foi implementado

![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/Strategy.png?raw=true)
		
As classe em que o método hit() é partilhado são as seguintes:
	
[MobileObjetct](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/MobileObject.java)

[Barrel](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/Barrel.java)

[Beer](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/Beer.java)

[Cactus](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/Cactus.java)

[Coin](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/Coin.java)

[Thief](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/Thief.java)


##### Consequências

O uso deste padrão permite que o algoritmo de resolução de colisão hit() possa variar consoante o tipo de objeto que
o está a usar.


## 3º

##### Problema no Contexto

Duas das funcionalidades do jogo seria mudar o aspeto de jogo consoante o tempo decorrido(simulando o dia e a noite) e mudar o sprite do score consoante o valor inteiro do score.
No entanto, gerenciar comportamentos diferentes existe uma grande complexidade no código (dependendo do número de estados) e a sua manutenção tornava-se difícil.

##### O Padrão

Para este problema, aplicamos o padrão de design **State**. 
Este padrão permite mudar o comportamento de um objeto consoante o seu estado (em run-time).
	
##### Implementação
		
As classe em que este padrão é aplicado são:
	
[SunMoon](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/SunMoon.java)

[Number](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/Number.java)

##### Consequências

O uso deste padrão permite que as transições de estado seja na classe SunMoon, em que temos a alternância entre Sol e Lua, ou na
classe Number, em que temos 10 estados e cada estado é um número, sejam explicítas e o código fica assim mais fácil de manter, mesmo 
depois de executar alterações ou aumentar estados.

## 4º

##### Problema no Contexto
	
Reprensentar o sprite do valor inteiro do score a partir da representação de cada número.

##### O Padrão

Para este problema, aplicamos o padrão de design **Composition**. 
Este padrão permite representar um objeto formado pela composição de objetos similares.
	
##### Implementação
		
A classe em que este padrão é utilizado é:

[Score](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/d738595e940684bebd62934129597ddf49ee96ba/project/src/main/java/Score.java)

##### Consequências

Este padrão permitiu que tratássemos cada número do score como uma sprite própria o score como uma composição de todos os sprites.
	
## 5º

##### Problema no Contexto

Ao longo do desenvolvimento do jogo, reparamos que a classe Arena tinha demasiadas responsabilidades, representava a arena, desenhava e controlava o funciomento dos elementos contidos nela.
Isto viola o ***The Single-responsibility principle*** e tornava o código dentro desta classe muito extenso e confuso.

##### O Padrão

Para este problema, aplicamos o padrão de design **Model View Controller(MVC)**. 
Este padrão separa as três principais funcionalidades da Arena em três classes diferentes.

##### Implementação

A imagem seguinte demonstra como é que o padrão de design foi implementado

![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/MVC.png?raw=true)
		
As classes referidas são as seguintes:

[ArenaDrawer](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/f99089bd9bc7fc6be782c31ea2d4996212917e67/project/src/main/java/ArenaDrawer.java)

[Arena](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/f99089bd9bc7fc6be782c31ea2d4996212917e67/project/src/main/java/Arena.java)

[ArenaController](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/f99089bd9bc7fc6be782c31ea2d4996212917e67/project/src/main/java/ArenaController.java)

##### Consequências

Este padrão permite cada classe tenha a sua responsabilidade e garante que para mudar como a arena é representada, ou o modo como é desenhada ou o seu funcionamento, é preciso apenas mudar uma classe.


**Diagrama UML**

![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/DiagramaUML.png?raw=true)






















