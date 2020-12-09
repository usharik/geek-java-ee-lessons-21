package ru.geekbrains.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.service.ToDoRepr;
import ru.geekbrains.service.ToDoServiceLocal;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/toDoQueue")
        }
)
public class JmsToDoBean implements MessageListener {

        private final Logger logger = LoggerFactory.getLogger(JmsToDoBean.class);

        @EJB
        private ToDoServiceLocal toDoService;

        @Override
        public void onMessage(Message message) {
                logger.info("New JMS message");

                if (message instanceof ObjectMessage) {
                        ObjectMessage om = (ObjectMessage) message;
                        try {
                                toDoService.insert((ToDoRepr) om.getObject());
                        } catch (JMSException e) {
                                logger.info("", e);
                        }
                }
        }
}
