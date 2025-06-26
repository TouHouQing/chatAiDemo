# ChatAI Demo - Intelligent Chat Application Platform

## 📖 Project Overview

ChatAI Demo is a full-stack intelligent chat application platform built with Spring Boot 3.5 and Vue 3. This project integrates multiple AI models and vector databases to provide diverse AI interaction experiences, including general chat, intelligent PDF Q&A, role-playing chat, and customer service functionality.

## ✨ Key Features

### 🤖 AI Chat Functionality
- **Multi-Model Support**: Integrated with OpenAI-compatible models (Qwen) and local Ollama models (DeepSeek-R1)
- **Intelligent Conversation**: Supports contextual memory for continuous dialogue
- **Streaming Response**: Real-time streaming output for enhanced user experience

### 📄 Intelligent PDF Q&A
- **Document Upload**: Support PDF file upload and online preview
- **Vector Storage**: Uses Milvus vector database for document vector storage
- **Intelligent Retrieval**: Semantic similarity-based document content retrieval
- **Q&A Interaction**: Intelligent question-answering based on PDF content

### 🎮 Role-Playing Chat
- **Game Characters**: Specialized game character chat mode
- **Customer Service**: Professional dialogue in customer service scenarios

### 💾 Data Management
- **Chat History**: Complete conversation history recording and management
- **File Storage**: Secure file upload and download mechanism
- **Data Persistence**: MySQL database for business data storage

## 🛠️ Technology Stack

### Backend Technologies
- **Framework**: Spring Boot 3.5.0
- **AI Integration**: Spring AI 1.0.0
- **Database**: MySQL 8.0
- **ORM**: MyBatis Plus 3.5.10
- **Vector Database**: Milvus
- **Build Tool**: Maven
- **Java Version**: JDK 17

### Frontend Technologies
- **Framework**: Vue 3.4 + TypeScript
- **Build Tool**: Vite 6.1
- **UI Library**: Naive UI 2.41
- **State Management**: Pinia 3.0
- **Router**: Vue Router 4.2
- **PDF Preview**: PDFTron WebViewer 11.3
- **Styling**: Sass + CSS3

### AI Models
- **OpenAI Compatible**: Qwen (qwen-turbo)
- **Local Model**: DeepSeek-R1:8b (Ollama)
- **Embedding Model**: text-embedding-v4

## 🚀 Quick Start

### System Requirements

- JDK 17+
- Node.js 18+
- MySQL 8.0+
- Milvus 2.0+
- Ollama (optional, for local models)

### Backend Deployment

1. **Clone the Project**
```bash
git clone <repository-url>
cd chatAiDemo
```

2. **Configure Database**
```sql
CREATE DATABASE chatAiDemo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. **Set Environment Variables**
```bash
export OPENAI_API_KEY=your_openai_api_key
export MYSQL_PASSWORD=your_mysql_password
```

4. **Modify Configuration File**
Edit `src/main/resources/application.yaml` and adjust the following configurations according to your environment:
- Database connection information
- Milvus service address
- AI model configuration

5. **Start the Application**
```bash
./mvnw spring-boot:run
```

The backend service will start at `http://localhost:8080`

### Frontend Deployment

1. **Navigate to Frontend Directory**
```bash
cd chatAiDemo-frontend
```

2. **Install Dependencies**
```bash
npm install
```

3. **Development Mode**
```bash
npm run dev
```

4. **Production Build**
```bash
npm run build
```

The frontend application will start at `http://localhost:5173`

## 📁 Project Structure

```
chatAiDemo/
├── src/main/java/com/touhouqing/chatAiDemo/
│   ├── controller/          # REST Controllers
│   │   ├── ChatController.java
│   │   ├── PdfController.java
│   │   ├── GameController.java
│   │   └── CustomerServiceController.java
│   ├── entity/             # Entity Classes
│   ├── service/            # Business Services
│   ├── repository/         # Data Access Layer
│   ├── config/             # Configuration Classes
│   └── tools/              # Utility Classes
├── src/main/resources/
│   ├── application.yaml    # Application Configuration
│   └── mapper/             # MyBatis Mapping Files
├── chatAiDemo-frontend/
│   ├── src/
│   │   ├── views/          # Page Components
│   │   │   ├── AIChat.vue
│   │   │   ├── ChatPDF.vue
│   │   │   ├── GameChat.vue
│   │   │   └── CustomerService.vue
│   │   ├── components/     # Common Components
│   │   ├── services/       # API Services
│   │   └── utils/          # Utility Functions
│   └── public/             # Static Resources
└── pom.xml                 # Maven Configuration
```

## 🔧 Configuration

### AI Model Configuration

The project supports two types of AI model configurations:

**OpenAI Compatible Model (Alibaba Cloud Qwen)**:
```yaml
spring:
  ai:
    openai:
      base-url: https://dashscope.aliyuncs.com/compatible-mode
      api-key: ${OPENAI_API_KEY}
      chat:
        options:
          model: qwen-turbo
          temperature: 0.5
```

**Local Ollama Model**:
```yaml
spring:
  ai:
    ollama:
      base-url: http://localhost:11434
      chat:
        model: deepseek-r1:8b
```

### Vector Database Configuration

```yaml
spring:
  ai:
    vectorstore:
      milvus:
        client:
          host: "your-milvus-host"
          port: 19530
        database-name: "chatAiDemo"
        collection-name: "chatPDF"
        embedding-dimension: 1024
```

## 🎯 Feature Modules

### 1. AI Intelligent Chat
- Path: `/ai-chat`
- Function: Basic AI dialogue with contextual memory support
- API: `GET /ai/chat`

### 2. PDF Intelligent Q&A
- Path: `/chat-pdf`
- Function: Upload PDF documents for intelligent Q&A based on document content
- APIs:
  - `POST /ai/pdf/upload/{chatId}` - File upload
  - `GET /ai/pdf/chat` - PDF Q&A
  - `GET /ai/pdf/file/{chatId}` - File download

### 3. Game Role Chat
- Path: `/game-chat`
- Function: Role-playing dialogue in gaming scenarios
- API: `GET /ai/game`

### 4. Customer Service
- Path: `/customer-service`
- Function: Professional dialogue in customer service scenarios
- API: `GET /ai/customer-service`

## 🤝 Contributing

1. Fork the project
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the [LICENSE](LICENSE) license.

## 📞 Contact

- Project Maintainer: touhouqing
- Email: qinghaoyang@foxmail.com
- Project Repository: [[GitHub Repository URL]](https://github.com/TouHouQing/chatAiDemo)

## 🔮 Future Roadmap

- [ ] Support for more AI model integrations
- [ ] Voice conversation functionality
- [ ] Improved PDF parsing algorithms
- [ ] User management system
- [ ] Multi-language internationalization support
- [ ] Mobile device optimization

---

**If this project helps you, please give it a ⭐ Star!**

## 🌐 Language Versions

- [中文版 README](README_zh.md)
- [English README](README.md) 
