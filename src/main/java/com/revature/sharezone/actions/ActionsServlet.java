package com.revature.sharezone.actions;


import com.revature.sharezone.contents.Contents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/actions")
public class ActionsServlet {

    private final ActionsServices actionsServices;

    @Autowired
    public ActionsServlet(ActionsServices actionsServices) {
        this.actionsServices = actionsServices;
    }

//    @PostMapping("/actions")
//    public ResponseEntity<UserProfile> saveActions(@RequestBody Actions actions){
//        Actions newActions = actionsServices.create(actions);
//       // return new ResponseEntity<>(newActions, HttpStatus.CREATED);
//    }

    @GetMapping("/actions-findall")
    public List<Actions> getAllActionsServices(){
        return actionsServices.readAll();
    }



    @GetMapping()
    public List<Actions> findAllActions(){
        return actionsServices.readAll();
    }


    @GetMapping("/findById")
    public ResponseEntity<Actions> findActionsById(@RequestParam String id){
        Actions actions = actionsServices.readById(id);
        return new ResponseEntity<>(actions, HttpStatus.OK);
    }

    @GetMapping("/findAllByContentsid")
    public List<Actions> findAllContentsBySection(@RequestParam String contentsid){
        return actionsServices.selectAllActionsByContentsId(contentsid);
    }

    @PostMapping()
    public ResponseEntity<Actions> saveUserProfile(@RequestBody Actions actions){
        Actions newActions = actionsServices.create(actions);
        return new ResponseEntity<>(newActions, HttpStatus.CREATED);
    }


    @DeleteMapping()
    public String deleteActionsById(@RequestParam String id) {
        actionsServices.delete(id);
        return "delete content : " + id + " working";
    }


    @PutMapping()
    public ResponseEntity<Actions> updateContent(@RequestBody Actions actions){
        Actions updatedActions = actionsServices.update(actions);
        return new ResponseEntity<>(updatedActions, HttpStatus.OK);
    }


}
