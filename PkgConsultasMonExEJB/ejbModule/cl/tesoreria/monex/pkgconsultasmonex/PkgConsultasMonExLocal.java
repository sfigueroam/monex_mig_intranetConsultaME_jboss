package cl.tesoreria.monex.pkgconsultasmonex; 

import java.math.BigDecimal;

import javax.ejb.Local;

@Local
public interface PkgConsultasMonExLocal {

    public AutorizadosResult autorizados(BigDecimal rutIn, BigDecimal formIn)
        throws PkgConsultasMonExException;
    public ConsultasResult consultas(BigDecimal rutIn, String dvIn, BigDecimal formIn, BigDecimal folioIn, String desdeIn, String hastaIn, String vencIn)
        throws PkgConsultasMonExException;
    public CuadraturaResult cuadratura(BigDecimal cod9927Aux)
        throws PkgConsultasMonExException;
    public EgresosResult egresos(BigDecimal agnoIn, BigDecimal rutIn)
        throws PkgConsultasMonExException;
    public ExpFormResult expForm(BigDecimal rutIn, String dvIn, BigDecimal formIn, BigDecimal folioIn, String desdeIn, String hastaIn, String vencIn)
        throws PkgConsultasMonExException;
    public GeneraHuinchaResult generaHuincha(BigDecimal cod9927Aux)
        throws PkgConsultasMonExException;
    public GeneraLibroContabmeResult generaLibroContabme(String periodocontab)
        throws PkgConsultasMonExException;
    public MovimientosResult movimientos(BigDecimal idIn, BigDecimal numtrxIn)
        throws PkgConsultasMonExException;
    public RectificadosResult rectificados(BigDecimal desdeIn, BigDecimal hastaIn, BigDecimal rutIn, BigDecimal idmovIn)
        throws PkgConsultasMonExException;
    public RecuperaArchResult recuperaArch(BigDecimal fechaIn, String tipoarchIn, BigDecimal idIn)
        throws PkgConsultasMonExException;
    public PeriodosContablesResult getPeriodosContables(BigDecimal anno)
        throws PkgConsultasMonExException;
    public void actPeriodosContables(String periodoIn)
        throws PkgConsultasMonExException;

}
