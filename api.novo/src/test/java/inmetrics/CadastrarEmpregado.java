package inmetrics;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CadastrarEmpregado {

	@Test
	public void cadastrarEmpregado() {

		RequestSpecification request = RestAssured.given().auth().preemptive().basic("inmetrics", "automacao");
		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("admissao", "01/01/2022");
		json.put("cargo", "QA");
		json.put("comissao", "50.000,00");
		json.put("cpf", "310.222.039-70");
		json.put("departamentoId", "1");
		json.put("nome", "Joana D avila");
		json.put("salario", "35.000,00");
		json.put("sexo", "f");
		json.put("tipoContratacao", "pj");


		request.body(json.toJSONString());
		Response response = request.post("https://inm-test-api.herokuapp.com/empregado/cadastrar");
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		System.out.println(response.jsonPath().getInt("empregadoId"));

	}

}
