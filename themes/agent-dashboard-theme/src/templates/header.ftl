<header id="banner" role="banner">

  <div id="heading">
    <div aria-level="1" class="site-title" role="heading">
      <h4>
        ${the_title}
      </h4>

      <#if !is_signed_in>
        <a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">
          ${sign_in_text}
        </a>
      </#if>
    </div>

    <div>
      <button 
        class="btn btn-primary" 
        onclick='Liferay.fire("displayProposalWidget", { proposalId: null });'>
        ${new_proposal_button}
      </button>
		</div>
	</div>
</header>