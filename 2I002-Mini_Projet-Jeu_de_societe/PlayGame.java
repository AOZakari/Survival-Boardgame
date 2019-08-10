import java.util.*;

public class PlayGame{

    public static void main(String[] args){

        System.out.println("Veuillez saisir le nombre de joueurs");
        Scanner sc = new Scanner(System.in);
        int nbJoueurs = sc.nextInt();
        Game game = new Game(nbJoueurs);
        Player [] players = game.getPlayers();
        Zone [] zones = new Zone[nbJoueurs*5];
        boolean tour = true;
        int action;
        int amount;
        int index;
        double percent;
        String type;


        //Initialisation de la partie:

        for (int i=0; i<nbJoueurs; i++){
            System.out.println("Joueur N°" + (i+1) + ":");
            for (int j=0; j<5; j++){
                zones[i*5+j] = Zone.newZone();
                zones[i*5+j].setPlayer(players[i]);
                players[i].getPossession().add(zones[i*5+j]);
                System.out.println(zones[i*5+j].toString());
            }
            System.out.println();
        }

        System.out.println("IT'S TIME TO D-D-D-D-D-DUUUUUUUUEL! \n\n\n\n");
        
        // Déroulement du jeu:

        for(int nbTours=0; nbTours<Game.NBTOURSMAX; nbTours++){
            for (Player player : players){
                if (player!=null){

                    player.setCptClean(player.getCptClean()+1);
                    player.regenerateRessources();
                    player.useRenewable();
                    tour = true;
                    
                    while(tour){
                        System.out.println("\n\n\n\n");
                        player.showInfoPossession();
                        System.out.println("Veuillez Choisir une Action: (le choix se fait en tapant le numéro correspondant)");
                        System.out.println("1- Produire de la nourriture: 1 Nourriture non traitée + 1 énergie -> 1 Nourriture");
                        System.out.println("2- Produire de l'énergie avec du pétrole: 1 pétrole + 100 argent -> 200 énergie + 2 Pollution Air + 2 Pollution Eau + 2 Pollution Terre");
                        System.out.println("3- Produire de l'énergie avec du gaz: 1 gaz + 100 argent -> 120 énergie + 2 Pollution Air + 1 Pollution Terre");
                        System.out.println("4- Produire de l'énergie avec du charbon: 1 pétrole + 100 argent -> 50 énergie + 1 Pollution Air + 1 Pollution Eau + 1 Pollution Terre");
                        System.out.println("5- Construire une station de purification: 50 Matière première + 10000 argent");
                        System.out.println("6- Construire une éolienne: 100 Matière première + 20000 argent");
                        System.out.println("7- Construire une turbine: 100 Matière première + 20000 argent");
                        System.out.println("8- Construire un panneau solaire: 100 Matière première + 20000 argent");
                        System.out.println("9- Effectuer un échange avec un joueur:");
                        System.out.println("10- Augmenter le QI d'une population:");
                        System.out.println("11- Terminer le tour");
                        System.out.println("\n\n\n\n");
                        sc = new Scanner(System.in);
                        action = sc.nextInt();
                        switch(action){
                            case 1:
                                System.out.println("Veuillez sélectionner une zone (saisissez un numéro de zone ou bien saisissez n'importe quel autre numéro pour annuler)");
                                index = sc.nextInt();
                                if(index>0 && index<=player.getPossession().size()){
                                    System.out.println("Veuillez saisir la quantité souhaitée (ou -1 pour annuler)");
                                    amount = sc.nextInt();
                                    player.getPossession().get(index-1).prodFood(amount);
                                }
                                break;
                            case 2:

                                System.out.println("Veuillez sélectionner une zone (saisissez un numéro de zone ou bien saisissez n'importe quel autre numéro pour annuler)");
                                index = sc.nextInt();
                                if(index>0 && index<=player.getPossession().size()){
                                    System.out.println("Veuillez saisir la quantité souhaitée (ou -1 pour annuler)");
                                    amount = sc.nextInt();
                                    player.useOil(index, amount);
                                }
                                break;
                            case 3:
                                
                                System.out.println("Veuillez sélectionner une zone (saisissez un numéro de zone ou bien saisissez n'importe quel autre numéro pour annuler)");
                                index = sc.nextInt();
                                if(index>0 && index<=player.getPossession().size()){
                                    System.out.println("Veuillez saisir la quantité souhaitée (ou -1 pour annuler)");
                                    amount = sc.nextInt();
                                    player.useGaz(index, amount);
                                }
                                break;
                            case 4:
                                
                                System.out.println("Veuillez sélectionner une zone (saisissez un numéro de zone ou bien saisissez n'importe quel autre numéro pour annuler)");
                                index = sc.nextInt();
                                if(index>0 && index<=player.getPossession().size()){
                                    System.out.println("Veuillez saisir la quantité souhaitée (ou -1 pour annuler)");
                                    amount = sc.nextInt();
                                    player.useCoal(index, amount);
                                }
                                break;
                            case 5:
                                
                                System.out.println("Veuillez sélectionner une zone (saisissez un numéro de zone ou bien saisissez n'importe quel autre numéro pour annuler)");
                                index = sc.nextInt();
                                if(index>0 && index<=player.getPossession().size()){
                                    System.out.println("Veuillez saisir la quantité souhaitée (ou -1 pour annuler)");
                                    amount = sc.nextInt();
                                    for (int i=0; i<amount; i++) player.getPossession().get(index-1).buildStatPuri();
                                }
                                break;
                            case 6:
                                
                                System.out.println("Veuillez sélectionner une zone (saisissez un numéro de zone ou bien saisissez n'importe quel autre numéro pour annuler)");
                                index = sc.nextInt();
                                if(index>0 && index<=player.getPossession().size()){
                                    System.out.println("Veuillez saisir la quantité souhaitée (ou -1 pour annuler)");
                                    amount = sc.nextInt();
                                    type = player.getPossession().get(index-1).getType();
                                    switch(type){
                                        case "Mountain": 
                                            for (int i=0; i<amount; i++) ((Mountain)(player.getPossession().get(index-1))).buildWindTurbine();
                                            break;
                                        case "Coast": 
                                            for (int i=0; i<amount; i++) ((Coast)(player.getPossession().get(index-1))).buildWindTurbine();
                                            break;
                                        case "City": 
                                            for (int i=0; i<amount; i++) ((City)(player.getPossession().get(index-1))).buildWindTurbine();
                                            break;
                                        case "Desert": 
                                            for (int i=0; i<amount; i++) ((Desert)(player.getPossession().get(index-1))).buildWindTurbine(); 
                                            break;
                                        default: 
                                           System.out.println("Erreur type");
                                    } 
                                }
                                break;
                            case 7:
                                
                                System.out.println("Veuillez sélectionner une zone (saisissez un numéro de zone ou bien saisissez n'importe quel autre numéro pour annuler)");
                                index = sc.nextInt();
                                if(index>0 && index<=player.getPossession().size()){
                                    System.out.println("Veuillez saisir la quantité souhaitée (ou -1 pour annuler)");
                                    amount = sc.nextInt();
                                    type = player.getPossession().get(index-1).getType();
                                    switch(type){
                                        case "Mountain": 
                                            for (int i=0; i<amount; i++) ((Mountain)(player.getPossession().get(index-1))).buildWaterTurbine();
                                            break;
                                        case "Coast": 
                                            for (int i=0; i<amount; i++) ((Coast)(player.getPossession().get(index-1))).buildWaterTurbine();
                                            break;
                                        case "City": 
                                            for (int i=0; i<amount; i++) ((City)(player.getPossession().get(index-1))).buildWaterTurbine();
                                            break;
                                        default: 
                                           System.out.println("Erreur type");
                                    }
                                }
                                break;
                            case 8:
                                
                                System.out.println("Veuillez sélectionner une zone (saisissez un numéro de zone ou bien saisissez n'importe quel autre numéro pour annuler)");
                                index = sc.nextInt();
                                if(index>0 && index<=player.getPossession().size()){
                                    System.out.println("Veuillez saisir la quantité souhaitée (ou -1 pour annuler)");
                                    amount = sc.nextInt();
                                    type = player.getPossession().get(index-1).getType();
                                    switch(type){
                                        case "Mountain": 
                                            for (int i=0; i<amount; i++) ((Mountain)(player.getPossession().get(index-1))).buildPanel();
                                            break;
                                        case "Coast": 
                                            for (int i=0; i<amount; i++) ((Coast)(player.getPossession().get(index-1))).buildPanel();
                                            break;
                                        case "City": 
                                            for (int i=0; i<amount; i++) ((City)(player.getPossession().get(index-1))).buildPanel();
                                            break;
                                        case "Desert": 
                                            for (int i=0; i<amount; i++) ((Desert)(player.getPossession().get(index-1))).buildPanel(); 
                                            break;
                                        default: 
                                           System.out.println("Erreur type");
                                    } 
                                }
                                break;
                            case 9:
                                
                                System.out.println("Veuillez sélectionner un autre joueur");
                                index = sc.nextInt();
                                if(index>0 && index<=nbJoueurs && index!=player.getID()){
                                    int playerFood, playerEnergy, playerMoney, opponentFood, opponentEnergy, opponentMoney;
                                    players[index-1].showInfoPossession();
                                    System.out.println("\n\n\n\n");
                                    System.out.println("Veuillez saisir le montant de la nourriture à donner");
                                    playerFood = sc.nextInt();
                                    System.out.println("Veuillez saisir le montant de l'énergie à donner");
                                    playerEnergy = sc.nextInt();
                                    System.out.println("Veuillez saisir le montant de l'argent à donner");
                                    playerMoney = sc.nextInt();
                                    System.out.println("Veuillez saisir le montant de la nourriture à recevoir");
                                    opponentFood = sc.nextInt();
                                    System.out.println("Veuillez saisir le montant de l'énergie à recevoir");
                                    opponentEnergy = sc.nextInt();
                                    System.out.println("Veuillez saisir le montant de l'argent à recevoir");
                                    opponentMoney = sc.nextInt();
                                    player.exchange(players[index-1], playerEnergy, playerFood, playerMoney, opponentEnergy, opponentFood, opponentMoney);
                                }
                                break;
                            case 10:
                
                                System.out.println("Veuillez sélectionner une zone (saisissez un numéro de zone ou bien saisissez n'importe quel autre numéro pour annuler)");
                                index = sc.nextInt();
                                if(index>0 && index<=player.getPossession().size()){
                                    System.out.println("Veuillez saisir la quantité souhaitée (ou -1 pour annuler)");
                                    amount = sc.nextInt();
                                    if (player.getXp()>=amount) player.getPossession().get(index-1).getPopulation().increaseIQ(amount);
                                    else System.out.println("XP insuffisants");
                                }
                                break;
                            case 11:
                                System.out.println("Votre tour viens de se terminer");
                                tour = false;
                                break;
                            default:
                                continue;
                        }
                    }

                    // Catastrophe Naturelle

                    percent = Math.random();
                    if(percent<0.3){
                        index = (int)(Math.random()*player.getPossession().size());
                        player.getPossession().get(index).callNaturalCatastrophy();
                    }

                    // Catastrophe Naturelle
                    
                    percent = Math.random();
                    if(percent<0.25){
                        index = (int)(Math.random()*player.getPossession().size());
                        player.getPossession().get(index).callPoliticalCatastrophy(game);
                    }

                    // Check des besoins

                    player.checkNeedsPP(); 

                    // Check si le joueur a gagné

                    if(player.checkWin() || nbJoueurs ==1){
                            System.out.println("Le joueur N°" + player.getID()+ " a gagné");
                            sc.close();
                            return;
                    }

                    // Check si le joueur a perdu

                    if(player.checkLoss()){
                            System.out.println("Le joueur N°" + player.getID()+ " a perdu");
                            game.eliminate(player.getID());
                            nbJoueurs--;
                    }
                }
            }

            //Appel de World War

            percent = Math.random();
            if(percent<0.1){
                Catastrophy.worldWar(game);
            }
        }

        // Fin de partie

        System.out.println("Le Soleil a atteint le stade de supernova et toute forme de vie sur terre a disparu");  
        sc.close(); 
        return;
    }
}