# 聊天AI演示项目 (基于Spring AI Alibaba)

本项目是一个基于Spring AI Alibaba的聊天AI演示项目，展示了多种AI应用场景的实现。

## 项目特性

- **多场景聊天**：基础聊天、游戏聊天、客服聊天、PDF文档聊天
- **多模态支持**：文本+图片输入
- **工具调用**：客服场景中的课程查询和预约功能
- **RAG知识库**：PDF文档上传和智能问答
- **聊天记忆**：多轮对话上下文保持
- **向量存储**：支持Milvus向量数据库

## 技术栈

- **后端框架**：Spring Boot 3.5.3
- **AI框架**：Spring AI Alibaba 1.0.0.2
- **大模型**：阿里云DashScope（通义千问）
- **向量数据库**：Milvus
- **关系型数据库**：MySQL + MyBatis Plus
- **图数据库**：Neo4j
- **前端框架**：Vue.js

## 环境配置

### 1. 环境变量设置

在启动项目前，需要设置以下环境变量：

```bash
# 阿里云DashScope API密钥
export DASHSCOPE_API_KEY=your_dashscope_api_key

# MySQL数据库密码
export MYSQL_PASSWORD=your_mysql_password

# Neo4j数据库密码
export NEO4J_PASSWORD=your_neo4j_password
```

### 2. 获取DashScope API Key

1. 访问 [阿里云DashScope控制台](https://dashscope.console.aliyun.com/)
2. 注册账号并开通服务
3. 在API Key管理页面创建新的API Key
4. 将API Key设置为环境变量 `DASHSCOPE_API_KEY`

### 3. 数据库配置

#### MySQL数据库
创建数据库 `chatAiDemo`，并执行 `sql.txt` 中的SQL脚本。

#### Milvus向量数据库
确保Milvus服务运行在 `43.143.215.162:19530`，或修改 `application.yaml` 中的配置。

#### Neo4j图数据库
配置Neo4j连接信息，或修改 `application.yaml` 中的配置。

## 项目启动

### 后端启动

```bash
# 编译项目
mvn clean compile

# 启动项目
mvn spring-boot:run
```

### 前端启动

```bash
cd chatAiDemo-frontend

# 安装依赖
npm install

# 启动开发服务器
npm run dev
```

## API接口

### 基础聊天
```
POST /ai/chat
参数：prompt（提问内容）, chatId（会话ID）, files（可选，多模态文件）
```

### 游戏聊天
```
POST /ai/game
参数：prompt（提问内容）, chatId（会话ID）
```

### 客服聊天
```
POST /ai/service
参数：prompt（提问内容）, chatId（会话ID）
```

### PDF文档聊天
```
POST /ai/pdf/chat
参数：prompt（提问内容）, chatId（会话ID）

POST /ai/pdf/upload/{chatId}
参数：file（PDF文件）
```

## 从Spring AI迁移说明

本项目已从原生Spring AI迁移到Spring AI Alibaba，主要变更：

1. **依赖更新**：使用 `spring-ai-alibaba-starter-dashscope` 替代 `spring-ai-starter-model-openai`
2. **配置变更**：使用 `spring.ai.dashscope` 配置替代 `spring.ai.openai`
3. **模型类更新**：使用 `DashScopeChatModel` 和 `DashScopeEmbeddingModel`
4. **API Key变更**：使用DashScope API Key替代OpenAI API Key

## 许可证

MIT License 
