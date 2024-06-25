Informações Gerais sobre o Projeto

Este projeto é uma emulação simplificada do jogo Dungeons & Dragons (D&D) utilizando Java puro. O objetivo é criar uma experiência básica de RPG onde os jogadores podem criar uma party de heróis, carregar uma party existente, e enfrentar combates contra inimigos. As funcionalidades principais incluem:

    Criação e edição de heróis com diferentes classes e atributos.
    Salvamento e carregamento da party de heróis.
    Sistema de combate baseado em turnos, seguindo regras básicas de D&D.
    Interação com o usuário via terminal para escolhas de ações durante o combate.

Informações sobre as Classes e suas Relações

O projeto é estruturado com várias classes principais e suas relações demonstram conceitos de agregação, composição, associação e herança:

    Classe App: Contém o método main que inicia a aplicação.
    Interface Ataque: Define os métodos para ações de ataque que todas as classes de personagens devem implementar.
    Classe GerDeParty: Gerencia a party de heróis, permitindo criar, editar, listar, excluir e carregar a party.
    Classe MenuPrincipal: Exibe o menu principal do jogo e permite navegar entre as opções de criar party, carregar party, ver regras e sair.
    Classe MenuCampanha: Exibe o menu da campanha, permitindo iniciar combates, listar party, editar party e excluir party.
    Classe Abstrata Heroi: Classe base para todos os heróis, implementa a interface Ataque e define atributos comuns.
        Subclasses Guerreiro, Mago, Ladino, Patrulheiro, Monge: Implementam características específicas de cada tipo de herói.
    Classe Abstrata Inimigo: Classe base para os inimigos, também implementa a interface Ataque.
        Subclasse Goblin: Implementa um tipo de inimigo específico.

Relações:

    Herança: Heroi é a classe mãe, e Guerreiro, Mago, Ladino, Patrulheiro, Monge são subclasses.
    Composição: GerDeParty contém uma lista de objetos Heroi.
    Agregação: MenuCampanha e MenuPrincipal utilizam GerDeParty para gerenciar a party.
    Associação: Ataque é uma interface implementada por Heroi e Inimigo.

Como Executar o Projeto

Para executar o projeto, siga as instruções abaixo:

    Clone o repositório:

    sh

git clone <URL-do-repositório>
cd <nome-do-diretório>

Compile o projeto:

sh

javac App.java

Execute o projeto:

sh

    java App

Certifique-se de que o arquivo party.txt está no mesmo diretório do projeto para carregar e salvar a party corretamente.
Uso do ChatGPT

O ChatGPT foi utilizado para auxiliar no desenvolvimento deste projeto, fornecendo orientação sobre estrutura de código, implementação de funcionalidades e correção de bugs. O modelo ajudou a:

    Criar e refinar a estrutura de classes e suas relações.
    Implementar a lógica de combate seguindo as regras de D&D.
    Melhorar a interação com o usuário no terminal.
    Gerar este README detalhado e informativo.

Referências e Recursos

    Documentação Java: Utilizada para referência de métodos e boas práticas de programação.
    Regras de Dungeons & Dragons: Referência básica para a criação das classes e lógica de combate.
    Tutoriais e Exemplos de Java: Recursos adicionais para implementar funcionalidades específicas e corrigir erros.

Este projeto é um exemplo prático de como conceitos de programação orientada a objetos podem ser aplicados para criar uma experiência de jogo interativa, simples e educativa.