# Expanded Vegetable Cooking

Expanded Vegetable Cooking e um mod NeoForge para Minecraft que adiciona novas plantacoes, ingredientes e receitas de comida ao jogo.

## Versoes

- Minecraft: `1.21.11`
- NeoForge: `21.11.42`
- Java: `21`
- Mod ID: `expanded_vegetable_cooking`
- Versao do mod: `2.0.0`

## Funcionalidades

### Nova aba criativa

O mod adiciona a aba criativa `Culinaria Vegetal Expandida`, alem de colocar os itens tambem na aba vanilla de comidas e bebidas.

### Plantacoes

- Arroz
- Feijao
- Milho
- Tomate

Cada plantacao possui:

- Bloco de crop com 8 estagios de crescimento
- Texturas proprias por estagio
- Blockstates e models
- Loot tables
- Tags de crop/semente em `data/c/tags/item`

### Ingredientes e comidas

- Arroz
- Sementes de arroz
- Feijao
- Milho
- Tomate
- Sementes de tomate
- Farinha
- Molho de tomate
- Macarrao cru
- Macarrao cozido
- Macarrao ao molho
- Tigela de arroz cru
- Tigela de feijao cru
- Arroz cozido
- Feijao cozido
- Arroz com feijao
- Feijao com farinha
- Cenoura cozida
- Beterraba cozida
- Ovo cozido
- Chocolate

As comidas em tigela devolvem uma tigela vazia quando consumidas por jogadores sem modo criativo.

## Receitas

### Crafting

- `raw_rice_bowl`: arroz + tigela
- `raw_beans_bowl`: feijao + tigela
- `raw_pasta`: trigo + ovo
- `flour`: 3 milhos em linha horizontal
- `tomato_sauce`: tomate + tomate + tigela
- `pasta_with_tomato_sauce`: macarrao cozido + molho de tomate
- `rice_and_beans`: arroz cozido + feijao cozido
- `beans_with_flour`: feijao cozido + farinha
- `chocolate`: sementes de cacau + balde de leite

### Fornalha, defumador e fogueira

O mod adiciona variantes de cozimento para:

- Arroz cozido
- Feijao cozido
- Cenoura cozida
- Beterraba cozida
- Ovo cozido
- Macarrao cozido

## Como buildar o jar

### Requisitos

Instale:

- Java Development Kit 21
- Git, se for clonar o repositorio

No Windows, use o wrapper Gradle incluido no projeto. Nao e necessario instalar Gradle separado.

### Build no Windows

Na raiz do projeto, execute:

```powershell
.\gradlew.bat build
```

### Build no Linux/macOS

Na raiz do projeto, execute:

```bash
./gradlew build
```

### Onde fica o jar

Depois do build, o jar gerado fica em:

```text
build/libs/
```

O arquivo principal segue o nome configurado pelo Gradle, usando o `mod_id` e a versao do mod.

## Rodar em desenvolvimento

Para abrir o cliente de desenvolvimento no Windows:

```powershell
.\gradlew.bat runClient
```

Para rodar servidor de desenvolvimento:

```powershell
.\gradlew.bat runServer
```

## Estrutura principal

- `src/main/java`: codigo Java do mod
- `src/main/resources/assets/expanded_vegetable_cooking`: texturas, modelos, traducoes e assets de cliente
- `src/main/resources/data/expanded_vegetable_cooking`: receitas e loot tables
- `src/main/resources/data/c`: tags comuns de crops e sementes
- `src/main/templates/META-INF/neoforge.mods.toml`: metadata do mod

## Licenca

All Rights Reserved.
