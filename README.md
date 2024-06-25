dnd

requisitos

* Coleções: Utilize coleções para armazenar e manipular dados.

- party criada (três heróis que nós criamos e salvamos, os heróis inimigos serão aleatórios, estou pensando em 
usar monstros, mas acho que não porque se não vou ter que escrever mais XD)

* Agregação, Composição e Associação: O projeto deve demonstrar o uso
de agregação, composição e associação.

- criação dos heróis da party

* Herança: Deve haver uma hierarquia de classes que demonstre herança.

- herói como mae
- classes (guerreiro, monge etc) extends herói


* Classes e Métodos Abstratos: Utilize classes e métodos abstratos onde
for apropriado.

- herói como mae (abstract)


* Interfaces: Implemente interfaces para definir contratos e promover
polimorfismo.

- ataques de cada classe

* Polimorfismo: Demonstre o uso de polimorfismo em seu projeto.

- diferença no dano e no tipo dos ataques (ataques especiais)

* Tratamento de Exceções: Inclua tratamento adequado de exceções para
garantir a robustez da aplicação.

- evitar erros do usuário na criação da party e possíveis bugs

* Persistência de Dados: Utilize leitura e gravação de dados em arquivos de
texto ou JSON.

- gravação em um txt das partys criadas junto com um log de cada combate

* Controle de Versão: Utilize o Git para controle de versão, com commits
claros e organizados.

- essa parte é complicada kkk

o Clean Code: Aplique os princípios de Clean Code para garantir a
legibilidade e a manutenibilidade do código.

- farei meu máximo !!!!

-------------------------------------------------------------------------------------

*menu1

- Iniciar campanha -

1 - criar minha party
2 - ver regras
3 - sair

if 1 {

"Aqui você criará seus três personagens para sua aventura!"

"--HEROI N°1--"

Nome: String
raca: (switch case

Anão
Elfo
Halfling
Humano
Draconato
Gnomo
Meio-Elfo
Meio-Orc
Tiefling
)

classe: (switch case - Guerreiro nome = new Guerreiro...

guerreiro
mago
ladino
patrulheiro
monge

)

"--HEROI N°2--"

...

"--HEROI N°3--"

...

--CÓDIGO DO QUE FOI MOSTRADO--

* criacao de personagem (a party criada deve ser gravada em um arquivo .txt chamado "party.txt")


classe abstract heroi - herança/encapsulamento

atributos dos herois:
nome
raca
hp
ca
iniciativa

classes public patrulheiro/guerreiro extends herói

*as classes são:
guerreiro
mago
ladino
patrulheiro
monge


atributos/interfaces/polimorfia e ações das classes:

*guerreiro
- forca + 3
[hp] - 50
[ca] - 18
[iniciativa] + 2 (polimorfia)
[atacar] - atacar com espada (polimorfia) hit (1d20 + 3) dmg (1d10 + 3)
[ataque especial] - corte giratório (interface) hit (2d8 + 3) dmg (2d8 + 3)

*mago
- magia + 2
[hp] - 25
[ca] - 13
[iniciativa] + 1 (polimorfia)
[atacar] - atacar com cajado (polimorfia) (1d20 + 2) dmg (1d8 + 2)
[ataque especial] - bola de fogo (interface) hit (1d10 + 2) dmg (3d10)


*ladino 
- furtividade + 4
[hp] - 30
[ca] - 14
[iniciativa] + 5 (polimorfia)
[atacar] - atacar com adaga (polimorfia) hit (1d20 + 4) dmg (1d8 + 4)
[ataque especial] - ataque furtivo (interface) hit (1d20) dmg (3d6 + 4)


*patrulheiro
- precisao + 5
[hp] - 35
[ca] - 14
[iniciativa] + 3 (polimorfia)
[atacar] - atacar com arco (polimorfia) hit (1d20 + 5) dmg (1d8 + 5)
[ataque especial] - disparo triplo (interface) hit (1d12 + 5) dmg (3d8 + 5)


*monge
- velocidade + 3
[hp] - 40
[ca] - 16
[iniciativa] + 4 (polimorfia)
[atacar] - atacar com soco (polimorfia) hit (1d20 + 3) dmg (2d6 + 3)
[ataque especial] - punho relâmpago (interface) hit (2d8 + 3) dmg (4d6 + 3)

}

if 2 {

"--REGRAS--"

...


}


if 3 {

"--FIM DO PROGRAMA--

...

}

-------------------------------------------------------------------------------------

*menu2

--INICIO--

switch case 
1 - iniciar combate 3x3
2 - listar party
3 - editar membro party
4 - excluir party
5 - sair

if 1 {

- atribui iniciativa para todos os membros da party 1 a 1 e também dos adversários

- rola 1d20 e add a iniciativa de cada classe

- a ordem de quem leva os ataques primeiro é:

1 - guerreiro
2 - monge
3 - patrulheiro
4 - ladino
5 - mago

- então basicamente, você só consegue atacar o que está na ordem, se tiver um guerreiro na party sempre começa atacando ele
se não tiver então passa para o outro da lista

--MENU DE COMBATE--
- quem está atacando (nome - classe)
- escolhe o atk (normal ou especial)
- se acertar da o dano no que está na vez de levar o dano (desconta o valor rolado do HP do personagem)
- passa para o próximo na iniciativa (independente de qual time seja o próximo é o com a próxima maior rolagem de iniciativa)

- ao final fazer um log das ações que aconteceram, envolvendo dano e quais ataques foram usados, esse log deve ser gravado 
em um txt chamado "relatório.txt"

*final do combate diz o vencedor e volta para o menu2

}

if 2 {

lista os membros da party

Rafael (humano)

Mago
hp - 
ca - 
atks -

...


------

Jorginho (Gnomo)

Guerreiro
hp ...

}

if 3 {


pede pra escolher qual gostaria de editar e ai vai para a criação de personagem de novo

...

}

if 4 {

- pergunta se tem certeza que deseja excluir a party

- se sim - reinicia a criação de toda a party

}

if 5 {

volta para menu1
...

}

else {
repete o menu
}






**Fazer tratamento de exceções no decorrer das funções acima**



03:07 - O que falta eu fazer?
- organizar o menu que está meio bagunçado
- depois da criação da party ir para o menu da campanha (menu2) PRIORIDADE
- fazer o esquema das regras
- fazer sistema de editar/excluir/listar party PRIORIDADE

04:42 - não sei o que está pior meu sono ou meu desespero por essa droga não estar funcionando, porque
essa party não está salavando

05:18 - Essa droga ta funcionando vez sim e vez não no sistema de menu (criar party/editar/excluir) porém funciona, não sei se é
terminal ou outra coisa assim, Mas enfim, vou terminar umas organizações, mas está faltando só o combate, vou ver se não consigo
fazer os inimigos também pra dar um adianto
