package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class KnihaSluzba {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<Kniha> seznamKnih;

    public KnihaSluzba() {
        try (InputStream inputStream = KnihaSluzba.class.getResourceAsStream("knihy.json")) {
            seznamKnih = objectMapper.readValue(inputStream, new TypeReference<List<Kniha>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Kniha> getSeznamKnih() {
        return seznamKnih;
    }

    public List<Kniha> getSeznamKnihAutora(String autor) {
        return getSeznamKnih()
                .stream()
                .filter(kniha -> kniha.getAutor().equals(autor))
                .toList();
    }

    public List<Kniha> getSeznamKnihRoku(int rok) {
        return getSeznamKnih()
                .stream()
                .filter(kniha -> kniha.getRokVydani() == rok)
                .toList();
    }
}
