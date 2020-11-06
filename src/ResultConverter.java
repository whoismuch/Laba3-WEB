import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ResultConverter implements Converter {

    @Override
    public Object getAsObject (FacesContext facesContext, UIComponent uiComponent, String s) {
        if (Boolean.valueOf(s).equals(true)) return "А ты хорош";
        else return "Loser";
    }

    @Override
    public String getAsString (FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o.toString().trim().equals("true")) return "А ты хорош";
        else return "Loser";
    }
}
