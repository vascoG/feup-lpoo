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


**Diagrama UML**

![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/DiagramaUML.png?raw=true)






















