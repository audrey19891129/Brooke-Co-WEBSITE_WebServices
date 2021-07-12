package model;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Gmail {

	 public static void sendEmail(String email, Order order, Address address) {

	        final String username = "lachapelle.audrey.1989@gmail.com";
	        final String password = "PASSWORD";

	        Properties prop = new Properties();
	        prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); 
	        
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("lachapelle.audrey.1989@gmail.com"));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(email)
	            );
	            message.setSubject("Confirmation de réception de la commande : " + order.getId());
	            message.setContent(
	            		 "<table width='700px' style='background-color:#f2f2f2;border:1.5px solid teal;font-size:20px;'>" +
	            	                "<thead>" +
	            	                    "<tr style='background-color: teal;'>" +
	            	                        "<th colspan='2' height='90px' style='text-align:center; vertical-align:central'><span style='font-size:25pt; color:white; font-weight:bold;'>CONFIRMATION DE COMMANDE</span></th>" +
	            	                    "</tr>" +
	            	                "</thead>" +
	            	                "<tbody>" +
	            	                    "<tr><td width='50%' style='padding-left:15px; padding-top:10px'>Numéro de commande :</td><td>"+order.getId()+"</td></tr>" +
	            	                    "<tr><td width='50%' style='padding-left:15px; padding-top:10px'>Sous-total :</td><td>"+order.getSubtotal()+"</td></tr>" +
	            	                    "<tr><td width='50%' style='padding-left:15px; padding-top:10px'>Frais de livraison fixe :</td><td>5.00 $</td></tr>" +
	            	                    "<tr><td width='50%' style='padding-left:15px; padding-top:10px'>Total :</td><td>"+String.format("%.2f",order.getTotal())+" $</td></tr>" +
	            	                    "<tr><td width='50%' style='padding-left:15px; padding-top:10px'>Date de livraison prévue :</td><td>" + order.getDelivery_date() + "</td></tr>" +
	            	                    "<tr><td width='50%' style='padding-left:15px; padding-top:10px'>Adresse de livraison :</td><td>"+address.toString()+"</td></tr>" +
	            	                    "<tr><td td colspan='2'></td></tr>" +
	            	                "</tbody>" +
	            	                "<tfoot>" +
	            	                    "<tr><td style='padding-top:20px;text-align:center;'  td colspan='2'>Merci de faire affaire avec Brooke et Co!</td></tr>" +
	            	                    "<tr><td colspan='2' style='text-align:center;'>Pour toute question ou commentaire vous pouvez téléphoner au :<br/> 1-800-123-4567</td></tr>" +
	            	                "</tfoot>" +
	            	            "</table>", "text/html"
	            		);

	            Transport.send(message);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	 }
}
