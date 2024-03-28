package uploadFileToDB;

	import java.sql.Connection;
import java.util.Properties;
	import javax.activation.DataHandler;
	import javax.activation.DataSource;
	import javax.activation.FileDataSource;
	import javax.mail.*;
	import javax.mail.internet.*;
	import java.io.File;

	public class EmailSender {
		static connectToDb DB=new connectToDb();

		 static Properties properties = DB.getProperties();
	    public void sendMail() {
		 //public static void main(String[] args) {
	        // Sender's email ID needs to be mentioned
	        final String from = properties.getProperty("email_sender");

	        // Recipient's email ID needs to be mentioned
	        String to = properties.getProperty("email_to");

	        // Sender's email password
	        final String password =properties.getProperty("password");

	        // SMTP server address
	        String host = properties.getProperty("host");
	        String port=properties.getProperty("port");
	       
	        // Setup mail server properties
	        Properties property = new Properties();
	        property.put("mail.smtp.host", host);
	        property.put("mail.smtp.port", port);
	        property.put("mail.smtp.auth", "true");
	        property.put("mail.smtp.starttls.enable", "true");

	        // Get the Session object
	        Session session = Session.getInstance(property, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(from, password);
	            }
	        });

	        try {
	            // Create a default MimeMessage object
	            Message message = new MimeMessage(session);

	            // Set From: header field of the header
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

	            // Set Subject: header field
	            message.setSubject("Meta response report");

	            // Create a multipart message
	            Multipart multipart = new MimeMultipart();

	            // Create the message part
	            BodyPart messageBodyPart = new MimeBodyPart();
	            String messageContent = "Dear User,\n" +
                        "Kindly check the attached pdf for meta data report.\n" +
                        "Regards,\n" +
                        "Arthavedika";
	            // Now set the actual message
	            messageBodyPart.setText(messageContent);

	            // Add the text message part to the multipart
	            multipart.addBodyPart(messageBodyPart);

	            // Part two is the attachment
	            messageBodyPart = new MimeBodyPart();
	            String filename = properties.getProperty("path_to_pdf");
	            System.out.println("path"+filename);
	            DataSource source = new FileDataSource(filename);
	            messageBodyPart.setDataHandler(new DataHandler(source));
	            messageBodyPart.setFileName(filename);

	            // Add attachment to the multipart
	            multipart.addBodyPart(messageBodyPart);

	            // Set the multipart message to the email message
	            message.setContent(multipart);

	            // Send message
	            Transport.send(message);

	            System.out.println("Email sent successfully...");
	            File file = new File(filename);
	            if (file.delete()) {
	                System.out.println("Attachment file deleted successfully.");
	            } else {
	                System.out.println("Failed to delete attachment file.");
	            }

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	}

