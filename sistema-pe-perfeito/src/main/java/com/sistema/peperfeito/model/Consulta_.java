package com.sistema.peperfeito.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Consulta.class)
public abstract class Consulta_ {

	public static volatile SingularAttribute<Consulta, Long> codigo;
	public static volatile SingularAttribute<Consulta, SituacaoConsulta> situacao;
	public static volatile SingularAttribute<Consulta, String> observacao;
	public static volatile SingularAttribute<Consulta, Paciente> paciente;
	public static volatile SingularAttribute<Consulta, Double> valor;
	public static volatile SingularAttribute<Consulta, LocalDateTime> dataHora;
	public static volatile SingularAttribute<Consulta, Podologo> podologo;

}

