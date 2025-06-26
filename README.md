# ChatAI Demo - 智能聊天应用平台

## 📖 项目简介

ChatAI Demo 是一个基于 Spring Boot 3.5 和 Vue 3 构建的全栈智能聊天应用平台。该项目集成了多种AI模型和向量数据库，提供多样化的AI交互体验，包括普通聊天、PDF智能问答、游戏角色聊天和客户服务等功能。

## ✨ 主要特性

### 🤖 AI聊天功能
- **多模型支持**: 集成OpenAI兼容模型（通义千问）和本地Ollama模型（DeepSeek-R1）
- **智能对话**: 支持上下文记忆的连续对话
- **流式响应**: 实时流式输出，提升用户体验

### 📄 PDF智能问答
- **文档上传**: 支持PDF文件上传和在线预览
- **向量化存储**: 使用Milvus向量数据库存储文档向量
- **智能检索**: 基于语义相似度的文档内容检索
- **问答交互**: 针对PDF内容进行智能问答

### 🎮 角色扮演聊天
- **游戏角色**: 专门的游戏角色聊天模式
- **客户服务**: 客服场景下的专业对话

### 💾 数据管理
- **聊天历史**: 完整的对话历史记录和管理
- **文件存储**: 安全的文件上传下载机制
- **数据持久化**: MySQL数据库存储业务数据

## 🛠️ 技术栈

### 后端技术
- **框架**: Spring Boot 3.5.0
- **AI集成**: Spring AI 1.0.0
- **数据库**: MySQL 8.0
- **ORM**: MyBatis Plus 3.5.10
- **向量数据库**: Milvus
- **构建工具**: Maven
- **Java版本**: JDK 17

### 前端技术
- **框架**: Vue 3.4 + TypeScript
- **构建工具**: Vite 6.1
- **UI库**: Naive UI 2.41
- **状态管理**: Pinia 3.0
- **路由**: Vue Router 4.2
- **PDF预览**: PDFTron WebViewer 11.3
- **样式**: Sass + CSS3

### AI模型
- **OpenAI兼容**: 通义千问 (qwen-turbo)
- **本地模型**: DeepSeek-R1:8b (Ollama)
- **嵌入模型**: text-embedding-v4

## 🚀 快速开始

### 环境要求

- JDK 17+
- Node.js 18+
- MySQL 8.0+
- Milvus 2.0+
- Ollama (可选，用于本地模型)

### 后端部署

1. **克隆项目**
```bash
git clone <repository-url>
cd chatAiDemo
```

2. **配置数据库**
```sql
CREATE DATABASE chatAiDemo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. **配置环境变量**
```bash
export OPENAI_API_KEY=your_openai_api_key
export MYSQL_PASSWORD=your_mysql_password
```

4. **修改配置文件**
编辑 `src/main/resources/application.yaml`，根据实际环境调整以下配置：
- 数据库连接信息
- Milvus服务地址
- AI模型配置

5. **启动应用**
```bash
./mvnw spring-boot:run
```

后端服务将在 `http://localhost:8080` 启动

### 前端部署

1. **进入前端目录**
```bash
cd chatAiDemo-frontend
```

2. **安装依赖**
```bash
npm install
```

3. **开发模式启动**
```bash
npm run dev
```

4. **生产环境构建**
```bash
npm run build
```

前端应用将在 `http://localhost:5173` 启动

## 📁 项目结构

```
chatAiDemo/
├── src/main/java/com/touhouqing/chatAiDemo/
│   ├── controller/          # REST控制器
│   │   ├── ChatController.java
│   │   ├── PdfController.java
│   │   ├── GameController.java
│   │   └── CustomerServiceController.java
│   ├── entity/             # 实体类
│   ├── service/            # 业务服务
│   ├── repository/         # 数据访问层
│   ├── config/             # 配置类
│   └── tools/              # 工具类
├── src/main/resources/
│   ├── application.yaml    # 应用配置
│   └── mapper/             # MyBatis映射文件
├── chatAiDemo-frontend/
│   ├── src/
│   │   ├── views/          # 页面组件
│   │   │   ├── AIChat.vue
│   │   │   ├── ChatPDF.vue
│   │   │   ├── GameChat.vue
│   │   │   └── CustomerService.vue
│   │   ├── components/     # 通用组件
│   │   ├── services/       # API服务
│   │   └── utils/          # 工具函数
│   └── public/             # 静态资源
└── pom.xml                 # Maven配置
```

## 🔧 配置说明

### AI模型配置

项目支持两种AI模型配置：

**OpenAI兼容模型（阿里云通义千问）**:
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

**本地Ollama模型**:
```yaml
spring:
  ai:
    ollama:
      base-url: http://localhost:11434
      chat:
        model: deepseek-r1:8b
```

### 向量数据库配置

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

## 🎯 功能模块

### 1. AI智能聊天
- 路径：`/ai-chat`
- 功能：基础AI对话，支持上下文记忆
- API：`GET /ai/chat`

### 2. PDF智能问答
- 路径：`/chat-pdf`
- 功能：上传PDF文档，进行基于文档内容的智能问答
- API：
  - `POST /ai/pdf/upload/{chatId}` - 文件上传
  - `GET /ai/pdf/chat` - PDF问答
  - `GET /ai/pdf/file/{chatId}` - 文件下载

### 3. 游戏角色聊天
- 路径：`/game-chat`
- 功能：游戏场景下的角色扮演对话
- API：`GET /ai/game`

### 4. 客户服务
- 路径：`/customer-service`
- 功能：专业的客服场景对话
- API：`GET /ai/customer-service`

## 🤝 贡献指南

1. Fork 本项目
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

## 📄 许可证

本项目基于 [LICENSE](LICENSE) 许可证开源。

## 📞 联系方式

- 项目维护者：touhouqing
- 邮箱：[联系邮箱]
- 项目地址：[GitHub仓库地址]

## 🔮 未来规划

- [ ] 支持更多AI模型接入
- [ ] 增加语音对话功能
- [ ] 优化PDF解析算法
- [ ] 添加用户管理系统
- [ ] 支持多语言国际化
- [ ] 移动端适配优化

---

**如果这个项目对您有帮助，请给它一个 ⭐ Star！** 