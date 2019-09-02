/*
As breadcrumb menùs are quite popular today, I won't digress much on explaining them, leaving the wiki link to do all the dirty work in my place.

        What might not be so trivial is instead to get a decent breadcrumb from your current url. For this kata, your purpose is to create a function that takes a url, strips the first part (labelling it always HOME) and then builds it making each element but the last a <a> element linking to the relevant path; last has to be a <span> element getting the active class.

        All elements need to be turned to uppercase and separated by a separator, given as the second parameter of the function; the last element can terminate in some common extension like .html, .htm, .php or .asp; if the name of the last element is index.something, you treat it as if it wasn't there, sending users automatically to the upper level folder.

        A few examples can be more helpful than thousands of words of explanation, so here you have them:

        Solution.generate_bc("mysite.com/pictures/holidays.html", " : ").equals( '<a href="/">HOME</a> : <a href="/pictures/">PICTURES</a> : <span class="active">HOLIDAYS</span>' );
        Solution.generate_bc("www.codewars.com/users/GiacomoSorbi", " / ").equals( '<a href="/">HOME</a> / <a href="/users/">USERS</a> / <span class="active">GIACOMOSORBI</span>' );
        Solution.generate_bc("www.microsoft.com/docs/index.htm", " * ").equals( '<a href="/">HOME</a> * <span class="active">DOCS</span>' );
        Seems easy enough?

        Well, probably not so much, but we have one last extra rule: if one element (other than the root/home) is longer than 30 characters, you have to shorten it, acronymizing it (i.e.: taking just the initials of every word); url will be always given in the format this-is-an-element-of-the-url and you should ignore words in this array while acronymizing: ["the","of","in","from","by","with","and", "or", "for", "to", "at", "a"]; a url composed of more words separated by - and equal or less than 30 characters long needs to be just uppercased with hyphens replaced by spaces.

        Ignore anchors (www.url.com#lameAnchorExample) and parameters (www.url.com?codewars=rocks&pippi=rocksToo) when present.

        Examples:

        Solution.generate_bc("mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.htm", " > ").equals( '<a href="/">HOME</a> > <a href="/very-long-url-to-make-a-silly-yet-meaningful-example/">VLUMSYME</a> > <span class="active">EXAMPLE</span>' );
        Solution.generate_bc("www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com/users/giacomo-sorbi", " + ").equals( '<a href="/">HOME</a> + <a href="/users/">USERS</a> + <span class="active">GIACOMO SORBI</span>' );
        You will always be provided valid url to webpages in common formats, so you probably shouldn't bother validating them.

        If you like to test yourself with actual work/interview related kata, please also consider this one about building a string filter for Angular.js.

        Special thanks to the colleague that, seeing my code and commenting that I worked on that as if it was I was on CodeWars, made me realize that it could be indeed a good idea for a kata :)
*/

package com.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreadcrumbGenerator {
    public static String generate_bc(String url, String separator) {
        StringBuilder result = new StringBuilder();
        List<String> list = new ArrayList<>(Arrays.asList(url.replaceAll("https?://|/index[.].*|([.]\\\\w+)?([?#].*)?|/$\", \"\"", "")
                .split("/")));
        if (list.size() > 1) {
            result.append("<a href=\"/\">HOME</a>").append(separator);
            StringBuilder acc = new StringBuilder();
            for (int i = 1; i < list.size() - 1; i++) {
                if (list.get(i).length() > 30) {
                    acc.append("/").append(list.get(i));
                    result.append(refactor(acc.toString(), list.get(i), false));
                } else {
                    acc.append("/").append(list.get(i));
                    result.append("<a href=\"")
                            .append(acc)
                            .append("/\">")
                            .append(list.get(i).replaceAll("-", " ").toUpperCase())
                            .append("</a>");
                }
                result.append(separator);
            }


            String last = list.get(list.size() - 1).replaceAll("\\..+$", "");
            if (last.length() > 30) {
                result.append(refactor(acc.toString(), last, true));
            } else {
                result.append("<span class=\"active\">")
                        .append(last.replaceAll("-", " ").toUpperCase())
                        .append("</span>");
            }
        } else {
            result.append("<span class=\"active\">HOME</span>");
        }

        return result.toString();
    }

    private static String refactor(String acc, String path, boolean isLast) {
        ArrayList<String> rule = new ArrayList<>(Arrays.asList("the", "of", "in", "from", "by", "with", "and", "or", "for", "to", "at", "a"));
        StringBuilder result = new StringBuilder();
        List<String> list = new ArrayList(Arrays.asList(path.split("-")));

        if (isLast) {
            result.append("<span class=\"active\">");
        } else {
            result.append("<a href=\"").append(acc).append("/\">");
        }

        for (String l : list) {
            if (rule.indexOf(l) > -1) {
                continue;
            }
            result.append(l.toUpperCase().charAt(0));
        }

        if (isLast) {
            return result.append("</span>").toString();
        } else {
            return result.append("</a>").toString();
        }

    }
}

/*

public class Solution {


    private static Set<String> IGNORE_WORDS = new HashSet<String>(Arrays.asList("the of in from by with and or for to at a".toUpperCase().split(" ")));


    public static String generate_bc(String url, String separator) {

        List<String> bcLst = new ArrayList();

        String[] urlArray = url.replaceAll("https?://|/index[.].*|([.]\\w+)?([?#].*)?|/$", "")
                .split("/");

        for (int i = 0 ; i < urlArray.length-1 ; i++) {
            if (i == 0) bcLst.add("<a href=\"/\">HOME</a>");
            else        bcLst.add(String.format("<a href=\"/%1$s/\">%2$s</a>", String.join("/", Arrays.copyOfRange(urlArray, 1, i+1)),
                    formatStr(urlArray[i])));
        }

        bcLst.add(String.format("<span class=\"active\">%s</span>", urlArray.length == 1 ? "HOME"
                : formatStr(urlArray[urlArray.length-1]) ));

        return String.join(separator, bcLst.toArray(new String[0]));
    }


    public static String formatStr(String item) {

        item = item.toUpperCase().replace("-"," ");
        if (item.length() > 30)
            item = Arrays.stream(item.split(" "))
                    .filter( s -> !IGNORE_WORDS.contains(s))
                    .map( s -> s.substring(0,1) )
                    .collect(Collectors.joining(""));
        return item;
    }
}*/
