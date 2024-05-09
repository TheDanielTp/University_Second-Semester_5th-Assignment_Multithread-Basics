# Multithread Questions
<!-- Improved compatibility of Back to Top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--



<!-- PROJECT SHIELDS -->
<!--
-->
[![TheDanielTp][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- ABOUT THE PROJECT -->
## 🔴 Question 1

What will be printed after interrupting the thread?

    public static class SleepThread extends Thread {
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            } finally {
                System.out.println("Thread will be finished here!!!");
            }
        }
    }

    public static void main(String[] args) {
        SleepThread thread = new SleepThread();
        thread.start();
        thread.interrupt();
    }
    
#### Answer:

- Thread was interrupted!
- Thread will be finished here!!!

Both the sentences will be printed. The message "Thread was interrupted!"" will be printed due catch block handling the InterruptedException. Then, the message "Thread will be finished here!!!" will also be printed because it's part of the finally block, which always executes.


<!-- GETTING STARTED -->
## 🟠 Question 2

In Java, what would be the outcome if the run() method of a Runnable object is invoked directly, without initiating it inside a Thread object?

    public class DirectRunnable implements Runnable {
        public void run() {
            System.out.println("Running in: " + Thread.currentThread().getName());
        }
    }

    public class Main {
        public static void main(String[] args) {
            DirectRunnable runnable = new DirectRunnable();
            runnable.run();
        }
    }
    
#### Answer:

- It will be executed in the current thread, not in a separate thread.

First, the code contains a mistake where the main function needs to not be static.

Second, If the run() method of a Runnable object is invoked directly without initiating it inside a Thread object, it will be executed in the current thread, not in a separate thread.

So, the message "Running in: Thread.currentThread().getName()" will be printed, where "Thread.currentThread().getName()"" is the name of the thread executing the main() method.

<!-- HOW TO USE -->
## 🟡 Question 3

Elaborate on the sequence of events that occur when the join() method of a thread (let's call it Thread_0) is invoked within the Main() method of a Java program.

    public class JoinThread extends Thread {
        public void run() {
            System.out.println("Running in: " + Thread.currentThread().getName());
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            JoinThread thread = new JoinThread();
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Back to: " + Thread.currentThread().getName());
        }
    }
    
#### Answer:
When the join() method of Thread_0 is invoked within the main() method:
- Thread_0 starts execution when thread.start() is called.
- The main thread then waits for Thread_0 to finish its execution by calling thread.join().
- If Thread_0 completes execution without being interrupted, the main thread continues its execution after thread.join() and prints "Back to: Main thread".

<!-- LICENSE -->
## 🔵 License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">Back to Top</a>)</p>



<!-- CONTACT -->
## 🟣 Contact

My Email - prof.danial4@gmail.com

Project Link: [https://github.com/TheDanielTp/2048](https://github.com/TheDanielTp/2048)

<p align="right">(<a href="#readme-top">Back to Top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/TheDanielTp/2048.svg?style=for-the-badge
[contributors-url]: https://github.com/TheDanielTp/2048/graphs/contributors
[Java-url]: https://www.java.com/en/
[Java.image]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[forks-shield]: https://img.shields.io/github/forks/TheDanielTp/2048.svg?style=for-the-badge
[forks-url]: https://github.com/TheDanielTp/2048/network/members
[stars-shield]: https://img.shields.io/github/stars/TheDanielTp/2048.svg?style=for-the-badge
[stars-url]: https://github.com/TheDanielTp/2048/stargazers
[issues-shield]: https://img.shields.io/github/issues/TheDanielTp/2048.svg?style=for-the-badge
[issues-url]: https://github.com/TheDanielTp/2048/issues
[license-shield]: https://img.shields.io/github/license/TheDanielTp/2048.svg?style=for-the-badge
[license-url]: https://github.com/TheDanielTp/2048/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 