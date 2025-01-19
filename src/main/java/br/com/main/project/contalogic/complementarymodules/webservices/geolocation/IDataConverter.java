package br.com.main.project.contalogic.complementarymodules.webservices.geolocation;

public interface IDataConverter {

    <T> T getData(String json, Class<T> finalClass);
}
