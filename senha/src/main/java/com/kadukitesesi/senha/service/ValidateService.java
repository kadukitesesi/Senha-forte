package com.kadukitesesi.senha.service;


import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ValidateService {

    public List<String> validaSenhaForte(String password) {
        List<String> exigencias = new ArrayList<>();
        quantidadeCaracteres(password, exigencias);
        temLetraMaiuscula(password, exigencias);
        temLetraMinuscula(password, exigencias);
        temNumero(password, exigencias);
        temCaractereEspecial(password, exigencias);

        return exigencias;
    }

    public static void quantidadeCaracteres(String password, List<String> exigencias) {
        if (StringUtils.isBlank(password) || password.length() < 8) {
            exigencias.add("A senha deve ter ao menos 8 caracteres");
        }
    }

    public static void temLetraMaiuscula(String password, List<String> exigencias) {
        if (!Pattern.matches(".*[A-Z].*",password)) {
            exigencias.add("A senha deve ter ao menos 1 letra maiuscúla");
        }
    }

    public static void temLetraMinuscula(String password, List<String> exigencias) {
        if (!Pattern.matches(".*[a-z].*",password)) {
            exigencias.add("A senha deve ter ao menos 1 letra minuscula");
        }
    }

    public static void temNumero(String password, List<String> exigencias) {
        if (!Pattern.matches(".*[0-9].*",password)) {
            exigencias.add("A senha deve ter ao menos 1 número");
        }
    }

    public static void temCaractereEspecial(String password, List<String> exigencias) {
        if (!Pattern.matches(".*[\\W].*",password)) {
            exigencias.add("A senha deve ter ao menos 1 caractereEspecial");
        }
    }
}
