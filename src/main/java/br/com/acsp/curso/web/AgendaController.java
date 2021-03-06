/**
 *
 */
package br.com.acsp.curso.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.service.AeronaveService;
import br.com.acsp.curso.service.AgendaService;
import br.com.acsp.curso.service.AlunoService;
import br.com.acsp.curso.service.AulaService;
import br.com.acsp.curso.service.InstrutorService;

/**
 * @author pedrosa
 */

@Controller
public class AgendaController extends AbstractController {

	@Autowired private AlunoService alunoService;
	@Autowired private AgendaService agendaService;
    @Autowired private AeronaveService aeronaveService;
    @Autowired private InstrutorService instrutorService;
    @Autowired private AulaService aulaService;
    

    /**
     * Este metodo adiciona a agenda ao (form) request, basta usar o form com o nome de "agenda"
     * @return
     */
    @ModelAttribute("agenda")
    public Agenda getAgenda() {
        return new Agenda();
    }

    @RequestMapping(value = "/agenda", method = RequestMethod.POST)
    public String criaAgendamento(@ModelAttribute("agenda") Agenda agenda) {
        agendaService.salvar(agenda);
        return "redirect:/agendas";
    }

    @RequestMapping(value = "/agenda", method = RequestMethod.GET)
    public String preparaForm(ModelMap map) {
    	map.put("listaDeAlunos", alunoService.listarOrdenado());
    	map.put("listaDeAeronaves", aeronaveService.listarOrdenadoPorModelo());
    	map.put("listaDeInstrutores", instrutorService.listarOrdenado());
    	map.put("listaDeAulas", aulaService.listarOrdenado());
    	return "agenda/formulario";
    }
    
    @RequestMapping(value = "/agenda/{id}", method = RequestMethod.GET)
	public String buscaPorId(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.put("agenda", agendaService.obtemPorId(id));
		modelMap.put("listaDeAlunos", alunoService.listarOrdenado());
		modelMap.put("listaDeAeronaves", aeronaveService.listarOrdenadoPorModelo());
		modelMap.put("listaDeInstrutores", instrutorService.listarOrdenado());
		modelMap.put("listaDeAulas", aulaService.listarOrdenado());
 
		return "agenda/formulario";
	}

    
    @RequestMapping(value = "/agenda/{id}", method = RequestMethod.POST)
	public String atualiza(@PathVariable("id") Long id,
			@ModelAttribute("agenda") Agenda agenda) {
    	agenda.setId(id);
    	agendaService.alterar(agenda);
		return "redirect:/agendas";
	}

    @RequestMapping(value = "/agendas", method = RequestMethod.GET)
    public String lista(ModelMap map) {
        map.put("listaDeAgendas", agendaService.pesquisarTodos());
        return "agenda/lista";
    }
    
	@RequestMapping(value = "/agenda/{id}/apaga", method = RequestMethod.GET)
	public String exclui(@PathVariable("id") Long id) {
		agendaService.excluirPorId(id);
		return "redirect:/agendas";
	}

    
}
