<script setup lang="ts">
import { ref } from 'vue'

const inputMessage = ref('')
const assistantMessage = ref('')
const loading = ref(false)
const errorMessage = ref('')

async function sendMessage() {
  if (!inputMessage.value.trim()) {
    errorMessage.value = 'Please enter a message.'
    return
  }

  loading.value = true
  errorMessage.value = ''
  assistantMessage.value = ''

  const requestBody = {
    model: 'gpt-oss:20b-cloud',
    messages: [
      {
        role: 'user',
        content: inputMessage.value
      }
    ],
    stream: false
  }

  try {
    const response = await fetch('http://localhost:8080/ollama/chat', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(requestBody)
    })

    if (!response.ok) {
      throw new Error(`Request failed: ${response.status}`)
    }

    const data = await response.json()

    assistantMessage.value = data.message
  } catch (error) {
    errorMessage.value = 'Failed to get response from server.'
    console.error(error)
  } finally {
    loading.value = false
  }
}
</script>

<template>
  <div class="page-wrapper">
    <el-card class="chat-card">
      <template #header>
        <div class="card-header">
          <span>WeTender Chat</span>
        </div>
      </template>

      <div class="chat-body">
        <div class="message user-message" v-if="inputMessage">
          <div class="message-label">You</div>
          <div class="message-content">{{ inputMessage }}</div>
        </div>

        <div class="message assistant-message" v-if="assistantMessage">
          <div class="message-label">Assistant</div>
          <div class="message-content">{{ assistantMessage }}</div>
        </div>

        <el-alert
            v-if="errorMessage"
            :title="errorMessage"
            type="error"
            show-icon
        />
      </div>

      <div class="chat-input-area">
        <el-input
            v-model="inputMessage"
            placeholder="Type your message..."
            clearable
            @keyup.enter="sendMessage"
        />

        <el-button
            type="primary"
            :loading="loading"
            @click="sendMessage"
        >
          Send
        </el-button>
      </div>
    </el-card>
  </div>
</template>

<style scoped>
.page-wrapper {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #f5f7fa;
}

.chat-card {
  width: 720px;
  height: 640px;
}

.card-header {
  font-size: 18px;
  font-weight: 600;
}

.chat-body {
  height: 480px;
  padding: 16px 0;
  overflow-y: auto;
}

.message {
  margin-bottom: 16px;
}

.message-label {
  font-size: 12px;
  color: #909399;
  margin-bottom: 4px;
}

.message-content {
  padding: 12px 14px;
  border-radius: 8px;
  line-height: 1.5;
  max-width: 80%;
}

.user-message {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

.user-message .message-content {
  background: #ecf5ff;
}

.assistant-message {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.assistant-message .message-content {
  background: #f4f4f5;
}

.chat-input-area {
  display: flex;
  gap: 12px;
  padding-top: 16px;
  border-top: 1px solid #ebeef5;
}
</style>