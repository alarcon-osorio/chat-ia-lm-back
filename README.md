🚀 Backend IA con LM Studio + Spring Boot

Este proyecto es un backend construido con Spring Boot que expone una API REST para interactuar con un modelo de IA local usando LM Studio.

Permite enviar prompts desde un frontend (Angular o React) y obtener respuestas generadas por un modelo LLM ejecutándose localmente.

📌 Tecnologías usadas
☕ Java 21
🍃 Spring Boot 3+
🌐 Spring Web (REST API)
🔗 WebClient / RestTemplate (consumo de LM Studio API)
🧠 LM Studio (modelo LLM local tipo Llama / Mistral / etc.)
📦 Maven
🧠 Arquitectura

El flujo es el siguiente:

Frontend (Angular / React)
↓
Backend Spring Boot (API REST)
↓
LM Studio (modelo IA local)
↓
Respuesta del modelo
↓
Frontend muestra respuesta
⚙️ Requisitos previos

Antes de ejecutar el proyecto asegúrate de tener:

Java 21 instalado
Maven instalado
LM Studio instalado 👉 https://lmstudio.ai
Un modelo descargado en LM Studio (ej: Llama 3, Mistral, etc.)

Servidor local de LM Studio activo en:

http://localhost:1234
🚀 Configuración de LM Studio
Abre LM Studio
Descarga un modelo (ej: Llama 3 8B)
Ve a la sección "Local Server"
Activa el servidor API
Verifica que esté corriendo en:
http://localhost:1234/v1/chat/completions
📦 Instalación del backend

Clonar el repositorio:

git clone https://github.com/tuusuario/tu-repo.git
cd tu-repo

Compilar el proyecto:

mvn clean install

Ejecutar:

mvn spring-boot:run
📡 Endpoint principal
🔹 Chat con IA

POST /api/chat

Request
{
"message": "Hola, ¿qué puedes hacer?"
}
Response
{
"response": "Soy un modelo de IA local ejecutándose en LM Studio..."
}
🧩 Configuración importante

En application.yml o application.properties:

lmstudio.api.url=http://localhost:1234/v1/chat/completions
lmstudio.model=local-model
🧠 Ejemplo de servicio (conceptual)
public String chat(String prompt) {
// Construye request hacia LM Studio
// Envía prompt
// Recibe respuesta del modelo
// Retorna texto generado
}
❌ Problemas comunes
1. Error de conexión a LM Studio
   Verifica que el servidor esté activo en puerto 1234
2. Respuestas vacías
   Revisa que el modelo esté cargado en LM Studio
3. CORS desde frontend
   Agrega configuración CORS en Spring Boot
   🌐 CORS (si usas frontend Angular)
   @Configuration
   public class CorsConfig {

   @Bean
   public WebMvcConfigurer corsConfigurer() {
   return new WebMvcConfigurer() {
   @Override
   public void addCorsMappings(CorsRegistry registry) {
   registry.addMapping("/**")
   .allowedOrigins("http://localhost:4200")
   .allowedMethods("*");
   }
   };
   }
   }
   📈 Futuras mejoras
   🔐 Autenticación JWT
   💬 Historial de conversaciones
   🧠 Soporte multi-modelo (LM Studio / OpenAI / Ollama)
   📊 Logging de prompts
   🧾 Persistencia en base de datos
   👨‍💻 Autor

Desarrollado por Jeison Alarcón
Proyecto educativo para integración de IA local con Spring Boot.