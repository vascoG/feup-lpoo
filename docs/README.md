Relatório Intermédio - Projeto LPOO 2021 - Grupo 41
===============

## Wild West StickMan

**Breve descrição do Jogo:**



Este projeto é parcialmente baseado no clássico offline **T-REX game**, jogo integrado no navegador Google Chrome.

O objectivo do jogo é ir coletando tokens que aleatoriamente instanciam,que contribuem para o score final do utilizador, enquanto que a personagem principal do jogo, neste caso uma espécie de stickman, corre pelo deserto até ficar sem vidas. Ao longo do jogo existem vários obstáculos diferentes com comportamentos diferentes em contacto com o personagem.


**Funcionamento do Jogo**

Em termos de movimento, a personagem principal está estática horizontalmente e apenas apresenta movimentos verticais controlados pelo utilizador, seja o salto (tecla 'w') e agachamento (tecla 's').


Os obstáculos que o jogador enfrenta estão dividos em dois tipos: **Obstáculos Perigosos** (retiram vida à personagem) e **Obstáculos Malandros** (roubam pontos do score do jogador).Nos obstáculos perigoso temos: barril (morre instantaneamente)e os cactos (retiram 1 unidade de vida).Nos obstáculos malandros temos: o Salteador (reduz o score do jogador para 0) e o Carteirista (retira 10% do score do jogador).

Em relação à dificuldade do jogo, ao longo do jogo a velocidade da passagem dos obstáculos pelo personagem vai aumentando o que dificulta a reação do jogador perante estes.


**Funcionalidades**


###### -> Salto Duplo

###### -> Agachamento

###### -> Salto

###### -> Apanhar Moedas

###### -> Deteção de Colisões

###### -> Desenhar

###### -> Alteração de Score(Incremento e Decremento)

###### -> Contador de Vida

###### -> HighScore

###### -> Verificar se o jogador perdeu o jogo a cada movimento


**Princípios (SOLID)**


###### -> S (The Single Responsibility Principle)

Mapa

Elemento

...

###### 














**Diagrama UML**

![alt text](https://github.com/FEUP-LPOO-2021/lpoo-2021-g41/blob/master/Images/DiagramaUML.png?raw=true)






















