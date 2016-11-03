package com.bhirava.ovilearning.constants;

public class ChildName {

    public static class LoginPage {
        public enum Child {
            HEADER_PANEL, VOID_LOGIN_PANEL
        }

        public enum HeaderPanel {
            IMAGE_PANEL, LABEL1, LABEL2
        }

        public enum LoginPanel {
            LOGIN_PANEL, LABEL, EMAIL, PWD, BUTTON
        }
    }

    public static class VideoListPage {
        public enum Child {
            HEADER_PANEL, NAVIGATION_PANEL, MAIN_PANEL
        }

        public enum HeaderPanel {
            IMAGE_PANEL, LABEL1, LABEL2
        }

        public enum MainPanel {
            PROGRESS_LABEL, PROGRESS_VALUE_LABEL, PROGRESS_BAR, QUIZZ_LABEL, QUIZZ_VALUE_LABEL, ASSIGNMENT_LABEL, ASSIGNMENT_VALUE_LABEL, IMAGE, TOPICS_PANEL, TOPICS_HEADING_PANEL
        }

        public enum TopicPanel {
            NUMBER_PANEL, LOGO, TOPIC_NAME, TOPIC_DURATION, BUTTON
        }
    }

    public enum General {
        CENTER_PANEL, BUTTON, IMAGE, LABEL, HEADING, SPLIT
    }

    public static class MainPage {
        public enum Child {
            HEADER_PANEL, FOOTER_PANEL, LOGIN_PANEL
        }

        public enum HeaderPanel {
            LOGO, SEARCH, REGISTER, LOGIN, TOUR, MEDIUM
        }

        public enum FooterPanel {
            COPY_RIGHTS_PANEL, MENU_PANEL, MENU1, MENU2, MENU3, INFO_LINE, INFO_LINE_TEXT, EMAIL, EMAIL_TEXT, LOGO
        }
    }

}
