package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.UtilisateurDao;
import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import fr.istic.taa.jaxrs.service.Impl.UtilisateurServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import fr.istic.taa.jaxrs.entity.Utilisateur;
import fr.istic.taa.jaxrs.service.UtilisateurService;
import jakarta.ws.rs.core.Response;

@Path("/utilisateur")
@Produces({"application/json", "application/xml","*/*"})
public class UtilisateurResource {

    private UtilisateurService utilisateurService;
    private EntityManager manager;

    public UtilisateurResource() {
        this.manager = EntityManagerHelper.getEntityManager();
        this.utilisateurService = new UtilisateurServiceImpl(new UtilisateurDao(manager));
    }

    public UtilisateurResource(UtilisateurService utilisateurService, EntityManager manager) {
        this.utilisateurService = utilisateurService;
        this.manager = manager;
    }

    @GET
    @Path("/find-all")
    public String findAll() {
        Utilisateur u = new Utilisateur("NOM_"+ UUID.randomUUID().toString().substring(0,6), "PRENOM_"+ UUID.randomUUID().toString().substring(0,6));
        utilisateurService.save(u);
        List<Utilisateur> utilisateurs = utilisateurService.findAll();
        return utilisateurs.stream().map(u1 -> u1.getNom()  + "   "+ u1.getPrenom()).collect(Collectors.joining(",<br> <br>"));

    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id){
        Utilisateur utilisateur = utilisateurService.findById(id);
        if(utilisateur == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return  Response.ok(utilisateurService.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") Long id){
        EntityTransaction tx = this.manager.getTransaction();
        tx.begin();
        utilisateurService.delete(id);
        tx.commit();
        return "Suppression réalisée avec succèes";
    }

    @GET
    @Path("/{nom}/{prenom}")
    @Produces("application/json")
    public Response findByNomAndPrenom(@PathParam("nom") String nom, @PathParam("prenom") String prenom){
        Utilisateur utilisateur = utilisateurService.findByNomAndPrenom(nom, prenom);
        if(utilisateur == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return  Response.ok(utilisateur).build();
    }

    @POST
    @Path("/{nom}/{prenom}")
    @Produces("application/json")
    public Response save(@PathParam("nom") String nom, @PathParam("prenom") String prenom){
        EntityTransaction tx = this.manager.getTransaction();
        tx.begin();
        Utilisateur utilisateur = new Utilisateur(nom, prenom);
        utilisateurService.save(utilisateur);
        tx.commit();
        return Response.ok(utilisateur).build();
    }
}
