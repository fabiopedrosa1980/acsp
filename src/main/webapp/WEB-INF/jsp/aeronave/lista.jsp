<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table>
        <thead>
            <td>Certificado de Matrícula:</td>
            <td>Marca:</td>
            <td>Modelo:</td>
            <td>DENTEL:</td>
            <td>FIAM:</td>
            <td>Apólice de Seguro:</td>
            <td>Ficha de Peso e Balanceamento:</td>
            <td>Manual de vôo:</td>
            <td>Check List:</td>
            <td>NSCA 3-5:</td>
            <td>NSCA 3-7:</td>
            <td>Diário de Bordo:</td>
            <td>Aeronave Ativa:</td>
            <td>Motivo de Inatividade:</td>
            <td>Acoes</td>
        </thead>
		<c:forEach var="aeronave" items="${listaDeAeronaves}">
			<tr>
                <td>${aeronave.certificadoMatricula}</td>
				<td>${aeronave.marca}</td>
                <td>${aeronave.modelo}</td>
                <td>${aeronave.dentel}</td>
                <td>${aeronave.fiam}</td>
                <td>${aeronave.apoliceSeguro}</td>
                <td>${aeronave.fichaPesoBalanceamento}</td>
                <td>${aeronave.manualVoo}</td>
                <td>${aeronave.checkList}</td>
                <td>${aeronave.nsca3_5}</td>
                <td>${aeronave.nsca3_7}</td>
                <td>${aeronave.diarioBordo}</td>
                <td>${aeronave.ativo}</td>
                <td>${aeronave.motivoInatividade}</td>
                <td>
                    <a href="http://localhost:8080/acsp/aeronave/${aeronave.id}">EDITAR</a> ||
                    <a href="http://localhost:8080/acsp/aeronave/${aeronave.id}/apaga">APAGA</a>
                </td>
			</tr>
		</c:forEach>
	</table>
<hr/>
<a href="http://localhost:8080/acsp/aeronave">Adicionar</a>
<c:import url="../../includes/footer.jsp"/>