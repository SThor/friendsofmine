package friendsofmine;

import friendsofmine.controllers.UtilisateurController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by 21301646 on 02/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilisateurControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UtilisateurController()).build();
    }

    @Test
    public void testUtilisateurs() throws Exception {
        this.mockMvc.perform(get("/utilisateurs"))
                .andExpect(status().isOk())
                .andExpect(view().name("utilisateurs"))
                .andDo(print());
    }
}
