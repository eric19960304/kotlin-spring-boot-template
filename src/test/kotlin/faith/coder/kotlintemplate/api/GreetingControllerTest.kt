package faith.coder.kotlintemplate.api

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.nio.charset.StandardCharsets

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class GreetingControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Throws(Exception::class)
    @Test
    fun testGetGreet() {
        val mvcResult : MvcResult = mockMvc.perform(get("/api/greet")).andExpect(status().isOk).andReturn()
        val responseText : String = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
        assertEquals("Hello!", responseText)
    }
}