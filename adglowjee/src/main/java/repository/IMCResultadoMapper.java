package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dto.IMCResultado;
import dto.TipoIMC;

public class IMCResultadoMapper implements RowMapper<IMCResultado> {

	@Override
	public IMCResultado mapRow(ResultSet rs, int arg1) throws SQLException {
		IMCResultado imcResultado = null;
		
			int id = rs.getInt("id");
			float peso = rs.getFloat("peso");
			float estatura = rs.getFloat("estatura");
			float imc_num = rs.getFloat("imc_num");
			String imc_nom = rs.getString("imc_nom");
			TipoIMC tipoIMC = TipoIMC.valueOf(imc_nom);
			String nombre = rs.getString("nombre");
			imcResultado = new IMCResultado(id, peso, estatura, imc_num, tipoIMC, nombre);
			
		return imcResultado;
	}

}
