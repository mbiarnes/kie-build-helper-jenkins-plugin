/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.jenkinsci.plugins.kieprbuildshelper;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RepositoryListsTest {

    private static final GitBranch BRANCH_72X = new GitBranch("7.26.x");

    @Test
    public void fetchRepositoryListForMaster() {
        List<Tuple<GitHubRepository, GitBranch>> repos = RepositoryLists.create(Tuple.of(RepositoryLists.KIE_BOOTSTRAP_REPO, GitBranch.MASTER),
                                                                                GitBranch.MASTER);
        // don't do too specific assertions as the repo list may change at any time as the test would then start failing
        // check just that the list is not empty as there should be always some repos
        Assertions.assertThat(repos).isNotEmpty();
    }

    @SuppressWarnings("unchecked")
	@Test
    public void fetchRepositoryListFor72x() {
        List<Tuple<GitHubRepository, GitBranch>> repos = RepositoryLists.create(Tuple.of(RepositoryLists.KIE_BOOTSTRAP_REPO, BRANCH_72X),
                                                                                new GitBranch("7.26.x"));
        // repo list for 7.26.x should be stable enough to make assertions on those
        Assertions.assertThat(repos).containsExactly(
                Tuple.of(new GitHubRepository("mbiarnes", "lienzo-core"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "lienzo-tests"), BRANCH_72X),                
                Tuple.of(new GitHubRepository("mbiarnes", "droolsjbpm-build-bootstrap"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "kie-soup"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "appformer"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "droolsjbpm-knowledge"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "drools"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "optaplanner"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "jbpm"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "kie-jpmml-integration"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "droolsjbpm-integration"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "openshift-drools-hacep"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "droolsjbpm-tools"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "kie-uberfire-extensions"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "kie-wb-playground"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "kie-wb-common"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "drools-wb"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "optaplanner-wb"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "jbpm-designer"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "jbpm-work-items"), BRANCH_72X),                
                Tuple.of(new GitHubRepository("mbiarnes", "jbpm-wb"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "kie-docs"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "optaweb-employee-rostering"), BRANCH_72X),
                Tuple.of(new GitHubRepository("mbiarnes", "optaweb-vehicle-routing"), BRANCH_72X),                
                Tuple.of(new GitHubRepository("mbiarnes", "kie-wb-distributions"), BRANCH_72X)
        );
    }

}
