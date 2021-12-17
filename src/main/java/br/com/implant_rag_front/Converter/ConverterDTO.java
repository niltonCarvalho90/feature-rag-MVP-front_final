package br.com.implant_rag_front.Converter;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.implant_rag_front.dto.DTOPadrao;

@FacesConverter(value="dtoConverter")
public class ConverterDTO implements Converter {

    @Override
    public Object getAsObject(final FacesContext ctx, final UIComponent component, final String value) {
        DTOPadrao retorno = null;
        if(value != null && !value.equals("") && !"null".equals(value)){
            final DTOPadrao objeto = (DTOPadrao) getAttributesFrom(component).get(value);
            if(objeto != null){
                retorno = objeto;
            }
        }
        return value != null ? retorno : null ;
    }

    @Override
    public String getAsString(final FacesContext ctx, final UIComponent component, final Object value) {
        if (value != null && !"".equals(value) && !"null".equals(value)) {
            final DTOPadrao objeto =  (DTOPadrao) value;
            addAttribute(component, objeto);
            //System.out.println(objeto != null ? objeto.getDescricaoTela() : null);
            return objeto != null ? objeto.getDescricaoTela() : null ;
        }
        //System.out.println(((DTOPadrao)value).getDescricaoTela());
        return ((DTOPadrao)value).getDescricaoTela();
    }

    protected void addAttribute(final UIComponent component, final DTOPadrao o) {
        final String key = o.getDescricaoTela() != null ? o.getDescricaoTela() : "" ;
        getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(final UIComponent component) {
        return component.getAttributes();
    }
}

