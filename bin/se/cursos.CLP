(deftemplate Usuario
	(slot nombre (type STRING))
	(slot area_interes (type STRING))
	(slot tipo_curso (type STRING))
	(slot presupuesto(type INTEGER))
)

(deftemplate Area_interes
	(slot nombre (type STRING))
	(slot descripcion (type STRING))
)

(deftemplate Curso
	(slot nombre (type STRING))
	(slot area (type STRING))
	(slot precio (type INTEGER))
	(slot tipo_curso (type STRING))
)

(deffacts hechos_iniciales
	(Area_interes 
		(nombre "culinaria")
		(descripcion " forma creativa de preparar los alimentos")
	)
	(Area_interes 
		(nombre "matematicas")
		(descripcion "estudia las propiedades y relaciones entre entidades abstractas como n�meros, figuras geom�tricas, iconos, glifos, o s�mbolos en general")
	)
	(Area_interes 
		(nombre "idiomas")
		(descripcion "lenguas extranjeras")
	)
	(Area_interes 
		(nombre "economia")
		(descripcion "estudia los recursos, la creaci�n de riqueza y la producci�n, distribuci�n y consumo de bienes y servicios")
	)
	(Area_interes 
		(nombre "contabilidad")
		(descripcion "Sistema de control y registro de los gastos e ingresos")
	)
	(Area_interes 
		(nombre "mercadotecnia")
		(descripcion "Conjunto de t�cnicas y estudios que tienen como objeto mejorar la comercializaci�n de un producto")
	)
	
	(Curso 
		(nombre "curso_reposteria_basica")
		(area "culinaria")
		(precio 60000)
		(tipo_curso "taller")
	)
	(Curso 
		(nombre "curso_comida_gourmet")
		(area "culinaria")
		(precio 80000)
		(tipo_curso "trimestral")
	)
	(Curso 
		(nombre "curso_cocina_africana")
		(area "culinaria")
		(precio 130000)
		(tipo_curso "bimestral")
	)
	(Curso 
		(nombre "curso_matematicas_aplicadas")
		(area "matematicas")
		(precio 500000)
		(tipo_curso "diplomado")
	)
	(Curso 
		(nombre "curso_matematicas_especiales")
		(area "matematicas")
		(precio 500000)
		(tipo_curso "diplomado")
	)
	(Curso 
		(nombre "curso_matematicas_avanzadas")
		(area "matematicas")
		(precio 600000)
		(tipo_curso "diplomado")
	)
	(Curso 
		(nombre "curso_ingles_avanzado")
		(area "idiomas")
		(precio 400000)
		(tipo_curso "semestral")
	)
	(Curso 
		(nombre "curso_ingles_basico")
		(area "idiomas")
		(precio 80000)
		(tipo_curso "bimestral")
	)
	(Curso 
		(nombre "curso_ingles_intermedio")
		(area "idiomas")
		(precio 150000)
		(tipo_curso "trimestral")
	)
	(Curso 
		(nombre "curso_finanzas_globales")
		(area "economia")
		(precio 350000)
		(tipo_curso "anual")
	)
	(Curso 
		(nombre "curso_finanzas_del_hogar")
		(area "economia")
		(precio 200000)
		(tipo_curso "semestral")
	)
	(Curso 
		(nombre "curso_finanzas_personales")
		(area "economia")
		(precio 150000)
		(tipo_curso "bimestral")
	)
	(Curso 
		(nombre "curso_marketing1")
		(area "mercadotecnia")
		(precio 600000)
		(tipo_curso "anual")
	)
	(Curso 
		(nombre "curso_marketing2")
		(area "mercadotecnia")
		(precio 600000)
		(tipo_curso "anual")
	)
	(Curso 
		(nombre "curso_marketing3")
		(area "mercadotecnia")
		(precio 600000)
		(tipo_curso "anual")
	)
	(Curso 
		(nombre "curso_contabilidad_basica")
		(area "contabilidad")
		(precio 40000)
		(tipo_curso "taller")
	)
	(Curso 
		(nombre "curso_contabilidad_intermedia")
		(area "contabilidad")
		(precio 40000)
		(tipo_curso "taller")
	)
	(Curso 
		(nombre "curso_contabilidad_avanzada")
		(area "contabilidad")
		(precio 100000)
		(tipo_curso "trimestral")
	)
)
(defrule recomendar

	(Usuario (nombre ?nom_usuario) (area_interes ?area) (tipo_curso ?tip) (presupuesto ?pre))
	(Curso (nombre ?nom_curso) (area ?area) (tipo_curso ?tip) (precio ?val))
	=>
	(if (>= ?pre ?val) then
		(printout log crlf)
	 	(printout log "Te recomendamos el curso de " ?nom_curso crlf " con una modalidad " ?tip crlf " que se adapta a tu tiempo y tiene un precio de " ?val crlf)
	 	(printout log "------------")
	) 
	
)