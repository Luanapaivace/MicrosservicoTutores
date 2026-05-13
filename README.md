# 🐾 Sistema Veterinário - Microsserviço de Tutores

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![HTML](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)

**Microsserviço responsável pelo gerenciamento dos tutores dos animais, parte integrante do Sistema Veterinário desenvolvido em arquitetura de microsserviços.**

</div>

---

## 📋 Sobre o Projeto

Este repositório contém o **microsserviço de Tutores**, desenvolvido por **Luana Oliveira** como parte de um sistema veterinário distribuído em arquitetura de microsserviços.

O sistema completo é composto por três repositórios independentes, cada um mantido por um(a) integrante da equipe, que se comunicam entre si via **APIs REST**:

| Microsserviço | Responsável | Repositório |
|---|---|---|
| 👤 **Tutores** | Luana Oliveira | ← este repositório |
| 🐶 **Pets** | Rayssa Fialho | repositório separado |
| 📅 **Agendamentos** | Gabriel Rolim | repositório separado |

---

## 👤 Microsserviço de Tutores

Responsável pelo gerenciamento completo dos tutores dos animais cadastrados no sistema, expondo uma **API REST** consumida tanto pela interface web quanto pelos demais microsserviços.

### ✅ Funcionalidades

- Cadastro de tutores
- Atualização cadastral
- Remoção de registros
- Listagem de tutores
- Consulta de informações específicas

### 📦 Modelo de Dados

| Campo | Tipo | Descrição |
|---|---|---|
| `id_tutor` | PK | Identificador único do tutor |
| `nome_completo_tutor` | — | Nome completo do tutor |
| `cpf` | — | CPF do tutor |
| `telefone` | — | Contato telefônico |
| `rua` | — | Rua do endereço |
| `numero` | — | Número do endereço |
| `bairro` | — | Bairro do endereço |

### 🌐 Interface Web

Página **HTML/CSS** integrada ao backend via **fetch API**, permitindo realizar todas as operações de CRUD pelo navegador sem ferramentas externas.

| Operação | Descrição |
|---|---|
| ➕ **Create** | Cadastro de novo tutor via formulário |
| 📋 **Read** | Listagem e visualização dos tutores cadastrados |
| ✏️ **Update** | Edição das informações de um tutor |
| 🗑️ **Delete** | Remoção de um tutor do sistema |

---

## 🔗 Integração com os Demais Microsserviços

Embora cada serviço seja independente e possua seu próprio repositório, eles se complementam e interagem via **APIs REST** para garantir a integridade dos dados em todo o sistema.

### 🐶 Serviço de Pets — Rayssa Fialho
O serviço de Pets utiliza o `id_tutor` como **chave estrangeira** para vincular cada animal ao seu tutor responsável. Antes de concluir um cadastro de pet, o serviço de Pets pode consultar a API de Tutores para validar se o tutor informado existe.

```
┌────────────────┐     REST API     ┌────────────────┐
│     Pets       │ ──────────────▶  │    Tutores     │
│  (R. Fialho)   │  valida tutor    │  (L. Oliveira) │
└────────────────┘                  └────────────────┘
```

### 📅 Serviço de Agendamentos — Gabriel Rolim
O serviço de Agendamentos utiliza o `id_tutor` como **chave estrangeira** para associar cada consulta ao tutor responsável. Antes de confirmar um agendamento, o serviço consulta a API de Tutores para verificar se o tutor existe no sistema.

```
┌──────────────────┐     REST API     ┌────────────────┐
│   Agendamentos   │ ──────────────▶  │    Tutores     │
│   (G. Rolim)     │  valida tutor    │  (L. Oliveira) │
└──────────────────┘                  └────────────────┘
```

> 💡 O microsserviço de Tutores é o **ponto de referência central** do sistema — tanto Pets quanto Agendamentos dependem dos dados de tutores para funcionar corretamente.

---

## 🛠️ Tecnologias Utilizadas

### Backend
| Tecnologia | Finalidade |
|---|---|
| **Java** | Linguagem principal de desenvolvimento |
| **Spring Boot** | Framework para criação do microsserviço |
| **Spring Data JPA** | Persistência e mapeamento de dados |
| **MySQL** | Banco de dados relacional |
| **Maven** | Gerenciamento de dependências |

### Frontend
| Tecnologia | Finalidade |
|---|---|
| **HTML5** | Estrutura da página de CRUD |
| **CSS3** | Estilização da interface web |

### Outros
| Tecnologia | Finalidade |
|---|---|
| **GitHub** | Controle de versão e colaboração |

---

<div align="center">

✨ **Projeto acadêmico desenvolvido para estudo de Arquitetura de Microsserviços**

Feito com ☕ e muito Java

</div>
