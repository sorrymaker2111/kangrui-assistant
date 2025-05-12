# 康睿助手 (Kangrui-Assistant)

![版本](https://img.shields.io/badge/版本-1.0-blue)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.6-green)
![LangChain4j](https://img.shields.io/badge/LangChain4j-1.0.0--beta3-purple)

## 项目简介

康睿助手是一个基于 Java 与大模型技术开发的智能医疗服务应用。该系统利用 LangChain4j 框架，结合大型语言模型（如通义千问），为用户提供医疗咨询、智能导诊、挂号预约等服务。

## 核心功能

- **智能医疗咨询**：用户可以咨询医疗健康相关问题，系统基于大模型提供专业的医疗建议
- **AI 分导诊**：根据患者的病情和就医需求，智能推荐最合适的科室
- **智能挂号助手**：
  - 查询挂号号源
  - 预约挂号服务
  - 取消挂号服务
- **流式输出**：支持大模型回答的流式输出，提升用户体验

## 技术架构

### 后端技术栈

- **基础框架**：Spring Boot 3.2.6
- **大模型集成**：LangChain4j 1.0.0-beta3
- **AI 模型**：通义千问系列模型（Qwen-Max, Qwen-Plus 等）
- **数据库**：
  - MySQL：存储挂号预约等业务数据
  - MongoDB：存储聊天记忆
- **向量检索**：Pinecone 向量数据库
- **接口文档**：Knife4j 4.3.0

### AI 能力

- **RAG 检索增强**：通过向量检索技术提升回答准确性
- **工具调用**：支持预约挂号、取消预约等工具功能
- **上下文记忆**：基于 MongoDB 实现的聊天上下文记忆功能
- **流式输出**：基于 Reactor 实现大模型流式响应

## 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 5.7+
- MongoDB 4.0+

### 配置说明

主要配置文件位于`src/main/resources/application.properties`，需要配置：

```properties
# 配置大模型API密钥
langchain4j.open-ai.chat-model.api-key=${DASH_SCOPE_API_KEY}
langchain4j.community.dashscope.chat-model.api-key=${DASH_SCOPE_API_KEY}

# 数据库连接配置
spring.data.mongodb.uri=mongodb://localhost:27017/chat_memory_db
spring.datasource.url=jdbc:mysql://localhost:3306/kangruiassistant
spring.datasource.username=root
spring.datasource.password=password
```

### 运行项目

```bash
# 克隆项目
git clone https://github.com/your-username/kangrui-assistant.git

# 进入项目目录
cd kangrui-assistant

# 编译并打包
mvn clean package

# 运行项目
java -jar target/java-ai-langchain4j-1.0-SNAPSHOT.jar
```

## 项目结构

```
src/main/java/com/sorrymaker/java/ai/langchain4j/
├── KangruiApp.java             # 应用程序入口
├── assistant/                  # AI助手相关类
│   ├── KangruiAgent.java       # 康睿助手代理
│   ├── MemoryChatAssistant.java # 带记忆的聊天助手
│   └── SeparateChatAssistant.java # 独立聊天助手
├── controller/                 # 控制器
│   └── KangruiController.java  # 康睿助手API接口
├── entity/                     # 实体类
│   └── Appointment.java        # 预约实体
├── service/                    # 服务层
├── mapper/                     # MyBatis映射接口
├── tools/                      # 大模型工具类
│   └── AppointmentTools.java   # 预约相关工具
├── config/                     # 配置类
│   └── KangruiAgentConfig.java # 康睿代理配置
└── bean/                       # 业务对象
```

## 系统特色

1. **医疗专业性**：系统经过医疗知识的专业提示词设计，能提供准确的医疗咨询
2. **智能工具调用**：基于 LangChain4j 的代理能力，实现精准的工具调用
3. **上下文理解**：支持上下文记忆，实现连贯的对话体验
4. **RAG 增强**：结合 Pinecone 向量数据库，实现知识检索增强
5. **流式响应**：基于 Reactor 的流式响应技术，提供更好的用户体验

## 联系方式

如有问题或建议，请联系项目维护者。

---
