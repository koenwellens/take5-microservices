package be.wellens.it.take5.score.service;

import be.wellens.it.take5.score.response.CalculateScoreResponse;
import org.assertj.core.api.AbstractAssert;

public class CalculateScoreResponseAssert extends AbstractAssert<CalculateScoreResponseAssert, CalculateScoreResponse> {

    public CalculateScoreResponseAssert(CalculateScoreResponse calculateScoreResponse) {
        super(calculateScoreResponse, CalculateScoreResponseAssert.class);
    }

    public static CalculateScoreResponseAssert assertThat(CalculateScoreResponse actual) {
        return new CalculateScoreResponseAssert(actual);
    }

    public CalculateScoreResponseAssert hasScore(int score) {
        // check that actual we want to make assertions on is not null.
        isNotNull();

        // check condition
        if (this.actual.getScore() != score) {
            failWithMessage("Expected calculated score to be <%d> but was <%s>", score, actual.getScore());
        }

        // return the current assertion for method chaining
        return this;
    }

    public CalculateScoreResponseAssert hasScoreZero() {
        return hasScore(0);
    }
}
