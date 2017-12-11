package facture;

import java.util.HashMap;

public class Catalogue {
     private HashMap<String, Article> articles;
     
     public Catalogue(){
         articles = new HashMap();
     }
    
    public void addArticle(Article article) {
         articles.put(article.getCode(), article);
    }
    
    public Article findByCode(String code) {
        Article ret = null;
         if (articles.containsKey(code) == true){
             ret = articles.get(code);
         }
         return ret;
    }
    
}
