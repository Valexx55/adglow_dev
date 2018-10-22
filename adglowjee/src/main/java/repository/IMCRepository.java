package repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dto.IMCResultado;


@Repository
public class IMCRepository {
	
	JdbcTemplate jdbcTemplate;
	
	private static final String RECUEPERAR_TODOS_IMC = "select * from imc_resultado";
	private static final String INSERTAR_IMC_RES = "INSERT INTO `eapro`.`imc_resultado` (`peso`, `estatura`, `imc_num`, `imc_nom`, `nombre`) VALUES (?, ?, ?, ?, ?)";
	
	@Autowired
	public IMCRepository (DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<IMCResultado> recuperarTodos ()
	{
		List<IMCResultado> lImcResultados = null;
		
			RowMapper<IMCResultado> rowMapper = new IMCResultadoMapper();
			lImcResultados = this.jdbcTemplate.query(RECUEPERAR_TODOS_IMC, rowMapper);
		
		return lImcResultados;
	}
	
	public boolean insertarIMCResultado (IMCResultado imcResultado)
	{
		boolean ok = false;
		int n_filas = -1;
		
			n_filas = this.jdbcTemplate.update(INSERTAR_IMC_RES, imcResultado.getPeso(), imcResultado.getEstatura(), imcResultado.getImc_num(), imcResultado.getImc_nom().toString(), imcResultado.getNombre());
			ok = (n_filas == 1);
			
			
		return ok;
	}
	
}
