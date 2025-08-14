package mytests;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub with argument matcher
        when(mockApi.getData(eq("123"))).thenReturn("Data for 123");

        // Service using mock
        MyService service = new MyService(mockApi);

        // Call method
        String result = service.fetchData("123");

        // Assert
        assertEquals("Data for 123", result);

        // Verify method called with correct argument
        verify(mockApi).getData(eq("123"));

        // Example: verify called with any string
        verify(mockApi).getData(anyString());
    }
}