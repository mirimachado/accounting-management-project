package br.com.main.project.contalogic.complementarymodules.webservices.utilities;

public interface IDataConverter {

    <T> T getData(String json, Class<T> finalClass);
}
